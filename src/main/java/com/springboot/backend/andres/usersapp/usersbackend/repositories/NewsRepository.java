package com.springboot.backend.andres.usersapp.usersbackend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.andres.usersapp.usersbackend.entities.News;

public interface NewsRepository extends CrudRepository<News, Long>{

    Page<News> findAll(Pageable pageable);
    Page<News> findByTitleContainingIgnoreCase(String title,Pageable pageable);
}
