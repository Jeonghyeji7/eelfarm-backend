package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.feed.FeedJournal;
import com.cuuva.springboot.model.feed.FeedJournalDTO;
import com.cuuva.springboot.repository.FeedJournalRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/feedjournal")
public class FeedJournalController {

	private final FeedJournalRepository feedJournalRepository;

	@GetMapping("/{feedJournalSn}")
	public FeedJournalDTO get(@PathVariable Integer feedJournalSn) {
		Optional<FeedJournal> optionalFeedJournal = feedJournalRepository
				.findById(feedJournalSn);

		return optionalFeedJournal.map(FeedJournalDTO::new).orElse(null);

	}

	@GetMapping
	public List<FeedJournalDTO> getList(
		@RequestParam("feedManageJournalSn") Integer feedManageJournalSn
	){
		List<FeedJournal> feedJournalList = feedJournalRepository
				.findAllByFeedManageJournalFeedManageJournalSn(feedManageJournalSn);

		List<FeedJournalDTO> feedJournalDTOList = new ArrayList<>();

		for (FeedJournal feedJournal : feedJournalList) {
			feedJournalDTOList.add(new FeedJournalDTO(feedJournal));
		}

		return feedJournalDTOList;
	}

	@PostMapping
	public FeedJournalDTO post(@RequestBody FeedJournal feedJournal) {
		return new FeedJournalDTO(feedJournalRepository.save(feedJournal));
	}

	@PutMapping("/{feedJournalSn}/feedOut")
	public FeedJournalDTO putFeedOut(@PathVariable Integer feedJournalSn, @RequestBody FeedJournal feedJournal) {
		Optional<FeedJournal> optionalCurrentFeedJournal = feedJournalRepository.findById(feedJournalSn);

		if (optionalCurrentFeedJournal.isPresent()) {
			FeedJournal currentFeedJournal = optionalCurrentFeedJournal.get();
			currentFeedJournal.setFeedOut(feedJournal.getFeedOut());
			return new FeedJournalDTO(feedJournalRepository.save(currentFeedJournal));
		}

		return null;
	}

	@PutMapping("/{feedJournalSn}")
	public FeedJournalDTO put(@PathVariable Integer feedJournalSn, @RequestBody FeedJournal feedJournal) {
		if (feedJournalSn != null) {
			feedJournal.setFeedJournalSn(feedJournalSn);
			return new FeedJournalDTO(feedJournalRepository.save(feedJournal));
		}

		return null;
	}
}
