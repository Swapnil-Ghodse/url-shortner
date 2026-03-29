package com.mybackendproj.url_shortner.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybackendproj.url_shortner.controller.ControllerShortner;
import com.mybackendproj.url_shortner.dtos.links.LinkDTO;
import com.mybackendproj.url_shortner.dtos.links.ResponseLinkDTO;
import com.mybackendproj.url_shortner.model.UrlModel;


@RestController
@RequestMapping("/short")
public class Shortner {

    private final ControllerShortner controllerShortner;

    public Shortner(ControllerShortner controllerShortner) {
         this.controllerShortner = controllerShortner;
    }


    @PostMapping("/url_shortner/{id}")
    public ResponseLinkDTO linkShortner(@PathVariable int id,  @RequestBody LinkDTO linkDTO){
        UrlModel fromShortController= controllerShortner.toShortLink(linkDTO.originalUrl);
        String url = fromShortController.getShort_url();
        return new ResponseLinkDTO("Ironman", url);
    }

    @GetMapping("/api/{encode_url}")
    public ResponseLinkDTO getOriginalLink(@PathVariable("encode_url") String encoded_url){
        String url = controllerShortner.decodeShortner(encoded_url);

        
         return new ResponseLinkDTO("Ironman", url);
    }

}
