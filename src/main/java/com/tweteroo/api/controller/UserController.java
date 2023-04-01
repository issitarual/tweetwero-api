package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.TweetUser;
import com.tweteroo.api.repository.UserRepository;

@RestController
@RequestMapping("/sign-up")
public class UserController {
    
    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity<String> create (@RequestBody UserDTO req) {
        repository.save(new TweetUser (req));
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
}
