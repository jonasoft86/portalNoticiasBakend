package com.springboot.backend.andres.usersapp.usersbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.*;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String title;
    private String summary;
    private String publishedAt;
    private String new_site;
    private String image_url;
    private String saved_at;

    public String getNew_site() {
        return new_site;
    }

    public void setNew_site(String new_site) {
        this.new_site = new_site;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getSaved_at() {
        return saved_at;
    }

    public void setSaved_at(String saved_at) {
        this.saved_at = saved_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }                                   


    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getPublishedAt() {
        return publishedAt;
    }                                           

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
