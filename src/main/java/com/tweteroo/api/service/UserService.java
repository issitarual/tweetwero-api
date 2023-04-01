package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.model.TweetUser;
import com.tweteroo.api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void save(TweetUser user){
        repository.save(user);
    }
    
}
