package com.springboot.backend.andres.usersapp.usersbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.andres.usersapp.usersbackend.entities.News;
import com.springboot.backend.andres.usersapp.usersbackend.repositories.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService {

    private NewsRepository repository;
    
    public NewsServiceImpl(NewsRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<News> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
        public Page<News> findByTitle(String title, Pageable pageable) {
        return repository.findByTitleContainingIgnoreCase(title, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<News> findAll() {
        return (List) this.repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<News> findById(@NonNull Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public News save(News user) {
        return repository.save(user);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
