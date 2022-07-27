package com.cuuva.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuuva.springboot.model.FeedManageJournal;
import com.cuuva.springboot.repository.FeedManageJournalRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class FeedManageJournalController {

	private FeedManageJournalRepository feedmanagejournalRepository;
	
	@GetMapping("/feedmanagejournal")
	public List<FeedManageJournal> getAllFeedManageJournals(){
		return feedmanagejournalRepository.findAll();
	}
}
