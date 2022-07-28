package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.feed.FeedManageJournal;
import com.cuuva.springboot.repository.FeedManageJournalRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/feedmanagejournal")
public class FeedManageJournalController {

	private final FeedManageJournalRepository feedmanagejournalRepository;

	@GetMapping
	public FeedManageJournal getListIsDate(
		@RequestParam("day") LocalDate feedManageJournalDt,
		@RequestParam("number") Integer eelFarmSn
	) {
		return feedmanagejournalRepository
			.findByFeedManageJournalDtAndEelFarmCommonEelFarmSn(
				feedManageJournalDt, eelFarmSn
			);
	}

	@GetMapping("/selectYearMonth")
	public List<FeedManageJournal> getListIsDate(
		@RequestParam("year") String year,
		@RequestParam("month") String month,
		@RequestParam("number") Integer eelFarmSn
	){
		return feedmanagejournalRepository.findWithNativeQuery1(year, month, eelFarmSn);
	}

	@GetMapping("/year")
	public List<String> getListSearchYear(
		@RequestParam("number") Integer eelFarmSn
	) {
		return feedmanagejournalRepository.findWithNativeQuery2(eelFarmSn);
	}

	@GetMapping("/month")
	public List<String> getListSearchMonth(
		@RequestParam("year") String year,
		@RequestParam("number") Integer eelFarmSn
	) {
		return feedmanagejournalRepository.findWithNativeQuery3(year, eelFarmSn);
	}

	@GetMapping("/journalCheck")
	public String getJournalCheck(
		@RequestParam("year") String year,
		@RequestParam("month") String month,
		@RequestParam("number") Integer eelFarmSn
	) {
		return feedmanagejournalRepository.findWithNativeQuery4(year, month, eelFarmSn);
	}

	@PostMapping
	public FeedManageJournal post(@RequestBody FeedManageJournal feedManageJournal) {
		return feedmanagejournalRepository.save(feedManageJournal);
	}
}
