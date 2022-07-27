package com.cuuva.springboot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cuuva.springboot.model.feed.Feed;

public interface FeedRepository extends JpaRepository<Feed, Integer>{
    List<Feed> findAllByEelFarmCommonEelFarmSn(Integer eelFarmSn);
}
