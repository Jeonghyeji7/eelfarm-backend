package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.feed.FeedManageJournal;
import com.cuuva.springboot.model.feed.FeedManageJournalDTO;
import com.cuuva.springboot.repository.FeedManageJournalRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
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
	public FeedManageJournalDTO getListIsDate(
		@RequestParam("day") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate feedManageJournalDt,
		@RequestParam("number") Integer eelFarmSn
	) {
		FeedManageJournal feedManageJournal = feedmanagejournalRepository
				.findByFeedManageJournalDtAndEelFarmCommonEelFarmSn(
						feedManageJournalDt, eelFarmSn
				);

		return new FeedManageJournalDTO(feedManageJournal);
	}

	@GetMapping("/selectYearMonth")
	public List<FeedManageJournalDTO> getListIsDate(
		@RequestParam("year") String year,
		@RequestParam("month") String month,
		@RequestParam("number") Integer eelFarmSn
	){
		List<FeedManageJournal> feedManageJournalList = feedmanagejournalRepository
				.findWithNativeQuery1(year, month, eelFarmSn);

		List<FeedManageJournalDTO> feedManageJournalDTOList = new ArrayList<>();

		for (FeedManageJournal feedManageJournal : feedManageJournalList) {
			feedManageJournalDTOList.add(new FeedManageJournalDTO(feedManageJournal));
		}

		return feedManageJournalDTOList;
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
