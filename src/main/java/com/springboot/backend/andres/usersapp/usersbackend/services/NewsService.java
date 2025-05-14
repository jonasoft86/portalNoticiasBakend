package com.springboot.backend.andres.usersapp.usersbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

import com.springboot.backend.andres.usersapp.usersbackend.entities.News;

public interface NewsService {

    List<News> findAll();

    Page<News> findAll(Pageable pageable);

    Optional<News> findById(@NonNull Long id);

    News save(News user);

    void deleteById(Long id);

    Page<News> findByTitle(String title,Pageable pageable);
}
