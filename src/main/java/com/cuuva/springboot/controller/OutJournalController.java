package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.out.OutJournal;
import com.cuuva.springboot.model.out.OutJournalDTO;
import com.cuuva.springboot.repository.OutJournalRepository;
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
@RequestMapping("/outjournal")
public class OutJournalController {

	private final OutJournalRepository outjournalRepository;

	@GetMapping
	public List<OutJournalDTO> getList(@RequestParam("outManageJournalSn") Integer outManageJournalSn){
		List<OutJournal> outJournalList = outjournalRepository
			.findAllByOutManageJournalOutManageJournalSn(outManageJournalSn);

		List<OutJournalDTO> outJournalDTOList = new ArrayList<>();

		for (OutJournal outJournal : outJournalList) {
			outJournalDTOList.add(new OutJournalDTO(outJournal));
		}

		return outJournalDTOList;
	}

	@PostMapping
	public OutJournalDTO post(@RequestBody OutJournal outJournal) {
		return new OutJournalDTO(outjournalRepository.save(outJournal));
	}

	@PutMapping
	public OutJournalDTO put(@RequestBody OutJournal outJournal) {
		return new OutJournalDTO(outjournalRepository.save(outJournal));
	}

	@DeleteMapping("/{outJournalSn}")
	public void delete(@PathVariable Integer outJournalSn) {
		outjournalRepository.deleteById(outJournalSn);
	}
}
