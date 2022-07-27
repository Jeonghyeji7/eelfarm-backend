package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.feed.FeedJournal;
import com.cuuva.springboot.repository.FeedJournalRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/feedjournal")
public class FeedJournalController {

	private final FeedJournalRepository feedJournalRepository;

	@GetMapping("/{feedJournalSn}")
	public FeedJournal get(@PathVariable Integer feedJournalSn) {
		return feedJournalRepository.findById(feedJournalSn).orElse(null);
	}

	@GetMapping
	public List<FeedJournal> getList(
		@Param("feedManageJournalSn") Integer feedManageJournalSn
	){
		return feedJournalRepository
			.findAllByFeedManageJournalFeedManageJournalSn(feedManageJournalSn);
	}

	@PostMapping
	public FeedJournal post(@RequestBody FeedJournal feedJournal) {
		return feedJournalRepository.save(feedJournal);
	}

	@PutMapping("/{feedJournalSn}/feedOut")
	public FeedJournal putFeedOut(@PathVariable Integer feedJournalSn, @RequestBody FeedJournal feedJournal) {
		Optional<FeedJournal> optionalCurrentFeedJournal = feedJournalRepository.findById(feedJournalSn);

		if (optionalCurrentFeedJournal.isPresent()) {
			FeedJournal currentFeedJournal = optionalCurrentFeedJournal.get();
			currentFeedJournal.setFeedOut(feedJournal.getFeedOut());
			feedJournalRepository.save(currentFeedJournal);
		}

		return null;
	}

	@PutMapping("/{feedJournalSn}")
	public FeedJournal put(@PathVariable Integer feedJournalSn, @RequestBody FeedJournal feedJournal) {
		if (feedJournalSn != null) {
			feedJournal.setFeedJournalSn(feedJournalSn);
			return feedJournalRepository.save(feedJournal);
		}

		return null;
	}
}
