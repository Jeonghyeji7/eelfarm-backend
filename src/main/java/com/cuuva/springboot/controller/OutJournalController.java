package com.cuuva.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuuva.springboot.model.OutJournal;
import com.cuuva.springboot.repository.OutJournalRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class OutJournalController {
	
	@Autowired
	private OutJournalRepository outjournalRepository;
	
	@GetMapping("/outjournal")
	public List<OutJournal>getAllOutJournals(){
		return outjournalRepository.findAll();
	}
	
	@PostMapping("/outjournal")
	public OutJournal createOutJournal(@RequestBody OutJournal outjournal) {
		return outjournalRepository.save(outjournal);
	}

//	@GetMapping("/outmanagejournal/isDate")
//	private
	
//	@PutMapping("/outjournal")
//	public ResponseEntity<OutJournal> updateOutJournal(@Param("eelFarmSn") Integer eelFarmSn,@Param("outJournalSn") Integer outJournalSn,@RequestBody OutJournal outjournalDetails){
//		OutJournal outjournal = outjournalRepository.findbyEelFarmSnAndOutJournalSn(eelFarmSn,outJournalSn)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + eelFarmSn,outJournalSn));
//
//		outjournal.setWatertankSn(outjournalDetails.getWatertankSn());
//		outjournal.setBreedSpecies(outjournalDetails.getBreedSpecies());
//		outjournal.setBreedCount(outjournalDetails.getBreedCount());
//		outjournal.setAverageWeight(outjournalDetails.getAverageWeight());
//
//		OutJournal updatedOutJournal = outjournalRepository.save(outjournal);
//
//		return ResponseEntity.ok(updatedOutJournal);
//	}
	
//	@DeleteMapping("/outjournal")
//	public ResponseEntity<Map<String, Boolean>> deleteOutJournal(@Param("eelFarmSn") Integer eelFarmSn,@Param("outJournalSn") Integer outJournalSn){
//		OutJournal outjournal = outjournalRepository.findbyEelFarmCommon_EelFarmSnAndOutJournalSn(eelFarmSn,outJournalSn);
//				//.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + outManageJournalDt));
//
//		outjournalRepository.delete(outjournal);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
	

}
