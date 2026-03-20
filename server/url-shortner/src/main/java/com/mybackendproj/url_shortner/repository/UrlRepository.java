package com.mybackendproj.url_shortner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybackendproj.url_shortner.model.UrlModel;

@Repository
public interface UrlRepository extends JpaRepository<UrlModel, Long> {

    UrlModel findByOriginalUrl(String originalUrl);
}
