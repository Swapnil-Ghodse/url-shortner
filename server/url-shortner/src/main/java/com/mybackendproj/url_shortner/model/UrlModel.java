package com.mybackendproj.url_shortner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="url_table")
public class UrlModel {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name="short_url", unique=true)
    private String shortUrl;

    @Column(name="original_url", unique=true)
    private String originalUrl;

    @Column(name="user_id")
    private Long userId;

    public Long getId() {
        return id;
    }

    public String getShort_url() {
        return shortUrl;
    }

    public String getOriginal_url() {
        return originalUrl;
    }

    public Long getUser_id() {
        return userId;
    }

    public void setShort_url(String short_url) {
        this.shortUrl = short_url;
    }

    public void setOriginal_url(String original_url) {
        this.originalUrl = original_url;
    }

    public void setUser_id(Long user_id) {
        this.userId = user_id;
    }

}
