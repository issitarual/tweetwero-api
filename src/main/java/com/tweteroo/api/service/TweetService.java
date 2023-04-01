package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repository.TweetRepository;

@Service
public class TweetService {
    
    @Autowired
    private TweetRepository repository;

    public List<Tweet> findAll(){
        return repository.findAll();
    }

    public List<Tweet> findByUsername(String username){
        return repository.findByUsername(username);
    }

    public void save(Tweet tweet){
        repository.save(tweet);
    }
}
