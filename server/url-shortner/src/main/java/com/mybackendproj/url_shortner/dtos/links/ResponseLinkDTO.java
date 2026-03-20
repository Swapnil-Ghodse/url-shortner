package com.mybackendproj.url_shortner.dtos.links;

public class ResponseLinkDTO {
    public String username;
    public String url;

    public ResponseLinkDTO(String username, String url){
        this.username = username;
        this.url = url;
    }
}
