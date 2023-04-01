package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.service.TweetService;

@RestController
@RequestMapping("/tweets/{username}")
public class TweetController {
    
    @Autowired
    private TweetService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody TweetDTO req) {
        service.save(new Tweet (req));
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    @GetMapping
    public List<Tweet> listTweetByUsername(
        @RequestBody TweetDTO req,
        @PathVariable(required = false) String username,
        @RequestParam(required = false) String page
    ) {
        if(username != null && page == null) {
            return service.findByUsername(username);
        }
        if(username == null && page == null) {
            return service.findAll();
        }
        if(username != null && page != null) {
            int number = Integer.parseInt(page);
            int pageNumber = number *5;
            List<Tweet> listAllTweets = service.findByUsername(username);
            return listAllTweets.subList(pageNumber - 5, pageNumber);
        }
        else{
            int number = Integer.parseInt(page);
            int pageNumber = number *5;
            List<Tweet> listAllTweets = service.findAll();
            if(listAllTweets.size() < 5){
                return listAllTweets;
            }
            return listAllTweets.subList(pageNumber - 5, pageNumber);
        }
    }
}
