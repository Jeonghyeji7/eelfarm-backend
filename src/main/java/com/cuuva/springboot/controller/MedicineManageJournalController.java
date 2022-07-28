package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.medicine.MedicineManageJournal;
import com.cuuva.springboot.repository.MedicineManageJournalRepository;
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
@RequestMapping("/medicinemanagejournal")
public class MedicineManageJournalController {

	private final MedicineManageJournalRepository medicineManageJournalRepository;

	@GetMapping("/isDate")
	public List<MedicineManageJournal> getListIsDate(
		@RequestParam("year") String year,
		@RequestParam("month") String month,
		@RequestParam("number") Integer eelFarmSn
	){
		return medicineManageJournalRepository
			.findAllByMedicineManageJournalYearAndMedicineManageJournalMonthAndEelFarmCommonEelFarmSn(
			year, month, eelFarmSn
		);
	}

	@GetMapping("/searchMonth")
	public List<String> getListSearchMonth(
		@RequestParam("year") String year,
		@RequestParam("number") Integer eelFarmSn
	){
		return medicineManageJournalRepository
			.findWithNativeQuery1(
				year, eelFarmSn
			);
	}

	@GetMapping("/searchYear")
	public List<String> getListSearchYear(
		@RequestParam("number") Integer eelFarmSn
	){
		return medicineManageJournalRepository.findWithNativeQuery2(eelFarmSn);
	}

	@PostMapping
	public MedicineManageJournal post(@RequestBody MedicineManageJournal medicineManageJournal) {
		return medicineManageJournalRepository.save(medicineManageJournal);
	}

	@DeleteMapping("/{medicineManageSn}")
	public boolean delete(@PathVariable Integer medicineManageSn) {
		medicineManageJournalRepository.deleteById(medicineManageSn);

		return true;
	}
}
