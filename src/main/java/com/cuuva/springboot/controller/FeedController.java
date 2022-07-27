package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.feed.Feed;
import com.cuuva.springboot.repository.FeedRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/feeds")
public class FeedController {

	private final FeedRepository feedRepository;

	@GetMapping
	public List<Feed> getList(@Param("number") Integer eelFarmSn){
		return feedRepository.findAllByEelFarmCommonEelFarmSn(eelFarmSn);
	}

	@PutMapping("/{feedCode}/name")
	public Feed putName(@PathVariable Integer feedCode, @RequestBody Feed feed) {
		Optional<Feed> optionalCurrentFeed = feedRepository.findById(feedCode);

		if (optionalCurrentFeed.isPresent()) {
			Feed currentFeed = optionalCurrentFeed.get();
			currentFeed.setFeedName(feed.getFeedName());
			feedRepository.save(currentFeed);
		}

		return null;
	}

	@PutMapping("/{feedCode}/standard")
	public Feed putStandard(@PathVariable Integer feedCode, @RequestBody Feed feed) {
		Optional<Feed> optionalCurrentFeed = feedRepository.findById(feedCode);

		if (optionalCurrentFeed.isPresent()) {
			Feed currentFeed = optionalCurrentFeed.get();
			currentFeed.setFeedStandard(feed.getFeedStandard());
			feedRepository.save(currentFeed);
		}

		return null;
	}
}
