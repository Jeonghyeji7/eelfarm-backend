package com.cuuva.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cuuva.springboot.model.out.OutManageJournal;
import com.cuuva.springboot.repository.OutManageJournalRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class OutManageJournalController {

	@Autowired
	private OutManageJournalRepository outManageJournalRepository;



	@PostMapping("/outmanagejournal")
	public OutManageJournal createOutManageJournal(@RequestBody OutManageJournal outManageJournal) {
		return outManageJournalRepository.save(outManageJournal);
	}



	@GetMapping("/outmanagejournal")
	public List<OutManageJournal> getAllOutManageJournal(){
		return outManageJournalRepository.findAll();
	}






}
