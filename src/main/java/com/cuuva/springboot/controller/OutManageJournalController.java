package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.out.OutManageJournal;
import com.cuuva.springboot.model.out.OutManageJournalDTO;
import com.cuuva.springboot.repository.OutManageJournalRepository;
import java.util.ArrayList;
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
@CrossOrigin(origins = {"http://210.217.121.58:28080", "http://192.168.10.11:3000", "http://localhost:3000"})
@RestController
@RequestMapping("/outmanagejournal")
public class OutManageJournalController {

	private final OutManageJournalRepository outManageJournalRepository;

	@GetMapping("/isDate")
	public List<OutManageJournalDTO> getListIsDate(
		@RequestParam("year") String year,
		@RequestParam("month") String month,
		@RequestParam("number") Integer eelFarmSn
	){
		List<OutManageJournal> outManageJournalList = outManageJournalRepository
			.findAllByOutManageJournalYearAndOutManageJournalMonthAndEelFarmCommonEelFarmSn(
				year, month, eelFarmSn
			);

		List<OutManageJournalDTO> outManageJournalDTOList = new ArrayList<>();

		for (OutManageJournal outManageJournal : outManageJournalList) {
			outManageJournalDTOList.add(new OutManageJournalDTO(outManageJournal));
		}

		return outManageJournalDTOList;
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
	public OutManageJournalDTO post(@RequestBody OutManageJournal outManageJournal) {
		return new OutManageJournalDTO(outManageJournalRepository.save(outManageJournal));
	}

	@DeleteMapping("/{outManageSn}")
	public boolean delete(@PathVariable Integer outManageSn) {
		outManageJournalRepository.deleteById(outManageSn);

		return true;
	}
}
