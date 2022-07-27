package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.medicine.MedicineJournal;
import com.cuuva.springboot.model.medicine.MedicineManageJournal;
import com.cuuva.springboot.repository.MedicineJournalRepository;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/medicinejournal")
public class MedicineJournalController {

	private final MedicineJournalRepository medicinejournalRepository;

	@GetMapping
	public List<MedicineJournal> getList(@Param("medicineManageSn") Integer medicineManageSn){
		return medicinejournalRepository
			.findAllByMedicineManageJournalMedicineManageSn(medicineManageSn);
	}

	@PostMapping
	public MedicineJournal post(@RequestBody MedicineJournal medicineJournal) {
		return medicinejournalRepository.save(medicineJournal);
	}

	@PutMapping
	public MedicineJournal put(@RequestBody MedicineJournal medicineJournal) {
		return medicinejournalRepository.save(medicineJournal);
	}

	@DeleteMapping("/{medicineSn}")
	public void delete(@PathVariable Integer medicineSn) {
		medicinejournalRepository.deleteById(medicineSn);
	}
}
