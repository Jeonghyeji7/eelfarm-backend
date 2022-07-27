package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.out.OutJournal;
import com.cuuva.springboot.repository.OutJournalRepository;
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
@RequestMapping("/outjournal")
public class OutJournalController {

	private final OutJournalRepository outjournalRepository;

	@GetMapping
	public List<OutJournal> getList(@Param("outManageJournalSn") Integer outManageJournalSn){
		return outjournalRepository
			.findAllByOutManageJournalOutManageJournalSn(outManageJournalSn);
	}

	@PostMapping
	public OutJournal post(@RequestBody OutJournal outJournal) {
		return outjournalRepository.save(outJournal);
	}

	@PutMapping
	public OutJournal put(@RequestBody OutJournal outJournal) {
		return outjournalRepository.save(outJournal);
	}

	@DeleteMapping("/{outJournalSn}")
	public void delete(@PathVariable Integer outJournalSn) {
		outjournalRepository.deleteById(outJournalSn);
	}
}
