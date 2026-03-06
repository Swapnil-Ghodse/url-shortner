package com.mybackendproj.url_shortner.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.seruco.encoding.base62.Base62;


@RestController
public class DemoController {

    Base62 base62;

    public DemoController() {
         base62 = Base62.createInstance();
    }


    @GetMapping("/api")
    public String helloWorld(){
        String base62_string = shortenID(10);
        return "BASE 62 value: " + base62_string + " for text "+ getOriginal(base62_string);
    }

    public String shortenID(int id){
        byte[] encodedBytes = base62.encode("Hello World!".getBytes());
        return new String(encodedBytes);
    }

    public String getOriginal(String base62_test){
        return new String( base62.decode(base62_test.getBytes()) );
    }
}
