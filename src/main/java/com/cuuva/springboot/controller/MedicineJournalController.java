//package com.cuuva.springboot.controller;
//
//import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.format.annotation.DateTimeFormat.ISO;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cuuva.springboot.model.MedicineJournal;
//import com.cuuva.springboot.repository.MedicineJournalRepository;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.cuuva.springboot.exception.ResourceNotFoundException;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/")
//public class MedicineJournalController {
//	
//	@Autowired
//	private MedicineJournalRepository medicinejournalRepository;
//	
//	@GetMapping("/medicinejournal")
//	public List<MedicineJournal> getAllMedicineJournal(){
//		return medicinejournalRepository.findAll();
//	}
////	
////	//
////	@PostMapping("/medicinejournal")
////	public MedicineJournal createMedicinejournal(@RequestBody MedicineJournal medicinejournal) {
////		return medicinejournalRepository.save(medicinejournal);
////	}
////	
////	//
////	@PutMapping("/medicinejournal")
////	public ResponseEntity<MedicineJournal> updateMedicineJournal(@RequestParam("medicineManageJournalDt") @DateTimeFormat(iso = ISO.DATE) LocalDate medicineManageJournalDt,@RequestBody MedicineJournal medicineDetails){
////		MedicineJournal medicinejournal = medicinejournalRepository.findById(medicineManageJournalDt)
////				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + medicineManageJournalDt));
////		medicinejournal.setLineSn(medicineDetails.getLineSn());
////		medicinejournal.setMedicineName(medicineDetails.getMedicineName());
////		medicinejournal.setMedicineInjectOrder(medicineDetails.getMedicineInjectOrder());
////		medicinejournal.setMedicineInjectNote(medicineDetails.getMedicineInjectNote());
////		MedicineJournal updatedMedicinejournal = medicinejournalRepository.save(medicinejournal);
////		return ResponseEntity.ok(updatedMedicinejournal);
////	}
////	
////	@DeleteMapping("/medicinejournal")
////	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@RequestParam("medicineManageJournalDt") @DateTimeFormat(iso = ISO.DATE) LocalDate medicineManageJournalDt){
////		MedicineJournal medicinejournal = medicinejournalRepository.findById(medicineManageJournalDt)
////				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + medicineManageJournalDt));
////		
////		medicinejournalRepository.delete(medicinejournal);
////		Map<String, Boolean> response = new HashMap<>();
////		response.put("deleted", Boolean.TRUE);
////		return ResponseEntity.ok(response);
////	}
//	
//	
//	
//	
//	
//	
//	
//	
//	//SELECT * FROM ef_medicine_journal WHERE YEAR(medicine_manage_journal_dt)=? AND MONTH(medicine_manage_journal_dt)=?
//	
////	@GetMapping("/medicinejournal/selectYearMonth")
////	public ResponseEntity<MedicineJournal> selectYearMonth(@RequestParam("year") String year,@RequestParam("month") String month){
////		return medicinejournalRepository.findAll();
////				
////		
////		 
////	}
//	
//	
////	@PostMapping("/medicineJournal")
////	public 
//	
//	//SELECT medicine_manage_journal_dt FROM ef_medicine_journal WHERE YEAR(medicine_manage_journal_dt)=? AND MONTH(medicine_manage_journal_dt)=?
//	
//	
//
//
//}
