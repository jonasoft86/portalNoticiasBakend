package com.springboot.backend.andres.usersapp.usersbackend.controllers;

import java.lang.System.Logger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.andres.usersapp.usersbackend.entities.News;
import com.springboot.backend.andres.usersapp.usersbackend.services.NewsService;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins={"http://localhost:4200/"})
@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService service;

    @GetMapping("/")
    public List<News> list() {
        return service.findAll();
    }

    @GetMapping("/page/{page}")
    public Page<News> listPageable(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 5);   
        return service.findAll(pageable);
    }

    @GetMapping("/filter/{title}/page/{page}")
    public Page<News> listByTitle(@PathVariable String title, @PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return service.findByTitle(title, pageable);
    }
   
    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Optional<News> userOptional = service.findById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(userOptional.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap("error", "no se encontro por el id:" + id));
    }
    
    @PostMapping("/")
    public ResponseEntity<News> create(@RequestBody News news) {
        System.out.println("news: " + news);
   
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(news));
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> update(@PathVariable Long id, @RequestBody News news) {
        Optional<News> userOptional = service.findById(id);

        if (userOptional.isPresent()) {
            News newsDb = userOptional.get();
            newsDb.setTitle(news.getTitle());
            newsDb.setSummary(news.getSummary());
            newsDb.setNew_site(news.getNew_site());
            newsDb.setImage_url(news.getImage_url());
            newsDb.setSaved_at(news.getSaved_at());
            return ResponseEntity.ok(service.save(newsDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<News> userOptional = service.findById(id);
        if (userOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}
