package com.cuuva.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cuuva.springboot.model.Feed;
import com.cuuva.springboot.repository.FeedRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class FeedController {
	
	@Autowired
	private FeedRepository feedRepository;
	
	@GetMapping("/feed")
	public List<Feed> getAllFeeds(){
		return feedRepository.findAll();
	}
	
	@PostMapping("/feed")
	public Feed createFeed(@RequestBody Feed feed) {
		return feedRepository.save(feed);
	}

//	@PutMapping("/feed")
//	public ResponseEntity<Feed> editFeed(@Param("feedCode") Integer feedCode, @RequestBody Feed feedDetails){
//		Feed feed = feedRepository.findById(feedCode)
//				.orElseThrow(()->new ResourceNotFoundException("id"+feedCode));
//
//		feed.setFeedName(feedDetails.getFeedName());
//		feed.setFeedStandard(feedDetails.getFeedStandard());
//		feed.setFeedSellerCode(feedDetails.getFeedSellerCode());
//
//		Feed uptatedFeed = feedRepository.save(feed);
//
//		return ResponseEntity.ok(uptatedFeed);
//	}

}
