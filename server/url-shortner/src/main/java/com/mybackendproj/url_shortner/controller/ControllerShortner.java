package com.mybackendproj.url_shortner.controller;

import org.springframework.stereotype.Service;

import com.mybackendproj.url_shortner.model.UrlModel;
import com.mybackendproj.url_shortner.repository.UrlRepository;

import io.seruco.encoding.base62.Base62;

@Service
public class ControllerShortner {
    Base62 base62;
    private UrlRepository urlRepository;

    public ControllerShortner(UrlRepository urlRepository) {
        base62 = Base62.createInstance();
        this.urlRepository = urlRepository;
    }

    public UrlModel toShortLink(String url){
        byte[] encodedBytes = base62.encode(url.getBytes());

        String urlEncoded = new String(encodedBytes);

        UrlModel existed_url = urlRepository.findByOriginalUrl(url);

        if(existed_url != null)
        {
            return existed_url;
        }

        UrlModel urlModel = new UrlModel();
        urlModel.setShort_url(urlEncoded);
        urlModel.setOriginal_url(url);
        urlModel.setUser_id(1l);

        urlRepository.save(urlModel);

        return urlModel;
    }

    public String decodeShortner(String url){
        byte[] decodedBytes = base62.decode(url.getBytes());
        return new String(decodedBytes);
    }
}
