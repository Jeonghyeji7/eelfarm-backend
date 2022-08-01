package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.medicine.MedicineJournal;
import com.cuuva.springboot.model.medicine.MedicineJournalDTO;
import com.cuuva.springboot.repository.MedicineJournalRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = {"http://210.217.121.58:28080", "http://192.168.10.11:3000", "http://localhost:3000"})
@RestController
@RequestMapping("/medicinejournal")
public class MedicineJournalController {

	private final MedicineJournalRepository medicinejournalRepository;

	@GetMapping
	public List<MedicineJournalDTO> getList(@RequestParam("medicineManageSn") Integer medicineManageSn){
		List<MedicineJournal> medicineJournalList = medicinejournalRepository
			.findAllByMedicineManageJournalMedicineManageSn(medicineManageSn);

		List<MedicineJournalDTO> medicineJournalDTOList = new ArrayList<>();

		for (MedicineJournal medicineJournal : medicineJournalList) {
			medicineJournalDTOList.add(new MedicineJournalDTO(medicineJournal));
		}

		return medicineJournalDTOList;
	}

	@PostMapping
	public MedicineJournalDTO post(@RequestBody MedicineJournal medicineJournal) {
		return new MedicineJournalDTO(medicinejournalRepository.save(medicineJournal));
	}

	@PutMapping
	public MedicineJournalDTO put(@RequestBody MedicineJournal medicineJournal) {
		return new MedicineJournalDTO(medicinejournalRepository.save(medicineJournal));
	}

	@DeleteMapping("/{medicineSn}")
	public void delete(@PathVariable Integer medicineSn) {
		medicinejournalRepository.deleteById(medicineSn);
	}
}
