package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.breed.BreedJournal;
import com.cuuva.springboot.model.breed.BreedJournalTotal;
import com.cuuva.springboot.repository.BreedJournalRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/breedjournal")
public class BreedJournalController {

	private final BreedJournalRepository breedjournalRepository;

	@GetMapping
	public List<BreedJournal> getList(
		@RequestParam("date") LocalDate breedJournalDt,
		@RequestParam("line") Integer lineSn,
		@RequestParam("number") Integer eelFarmSn
	) {
		return breedjournalRepository.findAllByBreedJournalDtAndLineInfoLineSnAndEelFarmCommonEelFarmSn(breedJournalDt, lineSn, eelFarmSn);
	}

	@GetMapping("/feed")
	public List<BreedJournal> getListFeed(
		@RequestParam("date") LocalDate breedJournalDt,
		@RequestParam("number") Integer eelFarmSn
	) {
		return breedjournalRepository.findAllByBreedJournalDtAndEelFarmCommonEelFarmSn(breedJournalDt, eelFarmSn);
	}

	@GetMapping("/pre")
	public List<BreedJournal> getListPre(
		@RequestParam("preDate") LocalDate breedJournalDt,
		@RequestParam("line") Integer lineSn,
		@RequestParam("water") Integer watertankSn,
		@RequestParam("number") Integer eelFarmSn
	) {
		return breedjournalRepository.findAllByBreedJournalDtAndLineInfoLineSnAndWatertankInfoWatertankSnAndEelFarmCommonEelFarmSn(breedJournalDt, lineSn, watertankSn, eelFarmSn);
	}

	@GetMapping("/total")
	public BreedJournalTotal getTotal(
		@RequestParam("date") LocalDate breedJournalDt,
		@RequestParam("line") Integer lineSn,
		@RequestParam("number") Integer eelFarmSn
	) {
		return breedjournalRepository.findWithNativeQuery(breedJournalDt, lineSn, eelFarmSn);
	}

	@PostMapping
	public BreedJournal post(@RequestBody BreedJournal breedJournal) {
		return breedjournalRepository.save(breedJournal);
	}

	@PutMapping
	public BreedJournal put(@RequestBody BreedJournal breedJournal) {
		return breedjournalRepository.save(breedJournal);
	}

	@PutMapping("/onlyPreData")
	public BreedJournal putOnlyPreData(@RequestBody BreedJournal breedJournal) {
		return breedjournalRepository.saveWithNativeQuery(breedJournal);
	}
}
