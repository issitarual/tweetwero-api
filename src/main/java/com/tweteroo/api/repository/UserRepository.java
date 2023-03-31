package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.TweetUser;

public interface UserRepository extends JpaRepository <TweetUser, Long> {
    
}
