package com.example.MyApp2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    DB db = new DB();

    @GetMapping("/hi")
    public String sayHello(){
        return "Hello to Spring Boot ";
    }

    // https://www.google.com/search?q=sachin
    // https://localhost:9090/search?q=sachin --> Query param of API

    @GetMapping("/search")
    public String search(@RequestParam String q){
        System.out.println("INput "+ q);
        return db.search(q);
    }
    // https://localhost:9090/users -> Get All users
    @GetMapping("/users")
    public List<User> getAllUser(){
        return db.getAllUsers();
    }

    // https://localhost:9090/users/2 -> Get A user (Path Param)
    @GetMapping("/users/{id}")
    public User getAUser(@PathVariable int id){
        return db.getAUser(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED) // 201
    public boolean createAUser(@RequestBody User user){
        return db.addAUser(user);
    }

    @PutMapping("/users")
    public boolean updateUser(@RequestBody User user){

        // logic
        return true;
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteAUser(@PathVariable int id){
        return db.deleteAUser(id);
    }

    // MySQL - Library App

    // Major - > Paytm App

    // Certificate - B.tech
    // Zomato - 2015 July :

}

