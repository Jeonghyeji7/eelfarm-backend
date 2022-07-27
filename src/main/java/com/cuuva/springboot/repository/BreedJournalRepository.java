package com.cuuva.springboot.repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;

import com.cuuva.springboot.model.BreedJournal;



@Repository
public interface BreedJournalRepository extends JpaRepository<BreedJournal,Long>{

	//List<BreedJournal> findByBreedJournalFeed(LocalDate breed_journal_dt);
	//@DateTimeFormat(iso = ISO.DATE) 
	
	
	//List<BreedJournal> findByLineAndBreedJournalDt(Integer line,LocalDate breedJournalDt);
	//LocalDate breed_journal_dt,
	
	//List<BreedJournal> findByLineAndBreedJournalDtAndWater(LocalDate breed_journal_dt,Integer line_sn,Integer watertank);
}
