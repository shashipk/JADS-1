package com.example.MyApp1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    // Get API
    @GetMapping("/hi")
    public String hello(){
        return "Hello";
    }

    // localhost:9000/search?q=Sachin
    // myownSerch/search?q=Sachin
    @GetMapping("/search")
    public String searchAWord(@RequestParam String word){
        DB db = new DB();
        return db.search(word);
    }

    // localhost:9000/read?id=2&name=Ramu
    @GetMapping("/read")
    public String searchAWord(@RequestParam String id,
                              @RequestParam String name){

        return "Hell0 "+ name + " "+ id;
    }

}
