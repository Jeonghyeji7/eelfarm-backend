package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.breed.BreedJournal;
import com.cuuva.springboot.model.breed.BreedJournalTotalInterface;
import com.cuuva.springboot.repository.BreedJournalRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = {"http://210.217.121.58:28080", "http://192.168.10.11:3000", "http://localhost:3000"})
@RestController
@RequestMapping("/breedjournal")
public class BreedJournalController {

	private final BreedJournalRepository breedjournalRepository;

	@GetMapping
	public List<BreedJournal> getList(
		@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate breedJournalDt,
		@RequestParam("line") Integer lineSn,
		@RequestParam("number") Integer eelFarmSn
	) {
		return breedjournalRepository.findAllByBreedJournalDtAndLineInfoLineSnAndEelFarmCommonEelFarmSn(breedJournalDt, lineSn, eelFarmSn);
	}

	@GetMapping("/feed")
	public List<BreedJournal> getListFeed(
		@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate breedJournalDt,
		@RequestParam("number") Integer eelFarmSn
	) {
		return breedjournalRepository.findAllByBreedJournalDtAndEelFarmCommonEelFarmSn(breedJournalDt, eelFarmSn);
	}

	@GetMapping("/pre")
	public List<BreedJournal> getListPre(
		@RequestParam("preDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate breedJournalDt,
		@RequestParam("line") Integer lineSn,
		@RequestParam("water") Integer watertankSn,
		@RequestParam("number") Integer eelFarmSn
	) {
		return breedjournalRepository.findAllByBreedJournalDtAndLineInfoLineSnAndWatertankInfoWatertankSnAndEelFarmCommonEelFarmSn(breedJournalDt, lineSn, watertankSn, eelFarmSn);
	}

	@GetMapping("/total")
	public BreedJournalTotalInterface getTotal(
		@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate breedJournalDt,
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
	public void putOnlyPreData(@RequestBody BreedJournal breedJournal) {
		breedjournalRepository.saveWithNativeQuery(breedJournal);
	}
}
