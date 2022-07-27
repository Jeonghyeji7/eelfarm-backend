package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.feed.FeedManageJournal;
import com.cuuva.springboot.model.out.OutManageJournal;
import com.cuuva.springboot.repository.FeedManageJournalRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/feedmanagejournal")
public class FeedManageJournalController {

	private final FeedManageJournalRepository feedmanagejournalRepository;

	@GetMapping
	public FeedManageJournal getListIsDate(
		@Param("day") LocalDate feedManageJournalDt,
		@Param("number") Integer eelFarmSn
	){
		return feedmanagejournalRepository
			.findByFeedManageJournalDtAndEelFarmCommonEelFarmSn(
				feedManageJournalDt, eelFarmSn
			);
	}

	@GetMapping("/selectYearMonth")
	public List<FeedManageJournal> getListIsDate(
		@Param("year") String year,
		@Param("month") String month,
		@Param("number") Integer eelFarmSn
	){
		return feedmanagejournalRepository.findWithNativeQuery1(year, month, eelFarmSn);
	}

	@GetMapping("/year")
	public List<String> getListSearchYear(
		@Param("number") Integer eelFarmSn
	){
		return feedmanagejournalRepository.findWithNativeQuery2(eelFarmSn);
	}

	@GetMapping("/month")
	public List<String> getListSearchMonth(
		@Param("year") String year,
		@Param("number") Integer eelFarmSn
	){
		return feedmanagejournalRepository.findWithNativeQuery3(year, eelFarmSn);
	}

	@PostMapping
	public FeedManageJournal post(@RequestBody FeedManageJournal feedManageJournal) {
		return feedmanagejournalRepository.save(feedManageJournal);
	}
}
