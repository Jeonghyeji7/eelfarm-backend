package com.cuuva.springboot.controller;

import com.cuuva.springboot.repository.MedicineJournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/medicinejournal")
public class MedicineJournalController {

	@Autowired
	private MedicineJournalRepository medicinejournalRepository;


}
