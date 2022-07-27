package com.cuuva.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuuva.springboot.model.BreedJournal;
import com.cuuva.springboot.repository.BreedJournalRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class BreedJournalController {
	
	@Autowired
	private BreedJournalRepository breedjournalRepository;
	
	@GetMapping("/breedjournal")
	public List<BreedJournal> getAll(){
		return breedjournalRepository.findAll();
	}
	
	//SELECT * FROM EF_BREED_JOURNAL WHERE breed_journal_dt=? AND line_sn=?
//	@GetMapping("/breedjournal")
//	public List<BreedJournal> findByDateAndLine(@Param("line") Integer line,@Param("breedJournalDt") @DateTimeFormat(iso = ISO.DATE) LocalDate breedJournalDt){
//		return breedjournalRepository.findByLineAndBreedJournalDt(line,breedJournalDt);
//	}
	//@DateTimeFormat(iso = ISO.DATE)
	//@Param("breed_journal_dt") 
	
	@PostMapping("/breedjournal")
	public BreedJournal createBreedJournal(@RequestBody BreedJournal breedJournal) {
		return breedjournalRepository.save(breedJournal);
	}
	
	
//	@GetMapping("/breedjournal/pre")
//	public List<BreedJournal> findByDateAndLineAndWater(@Param("breed_journal_dt") @DateTimeFormat(iso = ISO.DATE) LocalDate breed_journal_dt,@Param("line_sn") Integer line_sn,@Param("watertank") Integer watertank){
//		return breedjournalRepository.findByDateAndLineAndWater(breed_journal_dt,line_sn,watertank);
//	}
//	
//	//?? SELECT * FROM EF_BREED_JOURNAL WHERE breed_journal_dt=?
//	@GetMapping("/breedjournal/feed")
//	public List<BreedJournal> findByBreedJournalFeed(@Param("date") @DateTimeFormat(iso = ISO.DATE) LocalDate breed_journal_dt){
//		return breedjournalRepository.findByBreedJournalFeed(breed_journal_dt);
//				
//	}
//	

	
//	@PutMapping("/breedjournal")
//	public ResponseEntity<BreedJournal> updateBreedJournal(@RequestParam("breed_journal_dt") @DateTimeFormat(iso = ISO.DATE) LocalDate breed_journal_dt,@RequestParam("line_sn") Integer line_sn,@RequestParam("watertank") Integer watertank ,@RequestBody BreedJournal breedJournals){
//		BreedJournal breedjournal = breedjournalRepository.findById(Long row_id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//	}
	
	

}
