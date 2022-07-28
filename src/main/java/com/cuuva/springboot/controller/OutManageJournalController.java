package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.out.OutManageJournal;
import com.cuuva.springboot.repository.OutManageJournalRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/outmanagejournal")
public class OutManageJournalController {

	private final OutManageJournalRepository outManageJournalRepository;

	@GetMapping("/isDate")
	public List<OutManageJournal> getListIsDate(
		@RequestParam("year") String year,
		@RequestParam("month") String month,
		@RequestParam("number") Integer eelFarmSn
	){
		return outManageJournalRepository
			.findAllByOutManageJournalYearAndOutManageJournalMonthAndEelFarmCommonEelFarmSn(
				year, month, eelFarmSn
			);
	}

	@GetMapping("/searchMonth")
	public List<String> getListSearchMonth(
		@RequestParam("year") String year,
		@RequestParam("number") Integer eelFarmSn
	){
		return outManageJournalRepository
			.findWithNativeQuery1(
				year, eelFarmSn
			);
	}

	@GetMapping("/searchYear")
	public List<String> getListSearchYear(
		@RequestParam("number") Integer eelFarmSn
	){
		return outManageJournalRepository.findWithNativeQuery2(eelFarmSn);
	}

	@PostMapping
	public OutManageJournal post(@RequestBody OutManageJournal outManageJournal) {
		return outManageJournalRepository.save(outManageJournal);
	}

	@DeleteMapping("/{outManageSn}")
	public boolean delete(@PathVariable Integer outManageSn) {
		outManageJournalRepository.deleteById(outManageSn);

		return true;
	}
}
