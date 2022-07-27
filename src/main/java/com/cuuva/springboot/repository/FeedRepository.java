package com.cuuva.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuuva.springboot.model.Feed;

public interface FeedRepository extends JpaRepository<Feed,Integer>{

}
