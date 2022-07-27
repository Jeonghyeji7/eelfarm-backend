package com.cuuva.springboot.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuuva.springboot.model.OutJournal;

public interface OutJournalRepository extends JpaRepository<OutJournal, Integer>{


	//OutJournal findbyEelFarmCommon_EelFarmSnAndOutJournalSn(Integer eelFarmSn,Integer outJournalSn);

	//Optional<OutJournal> findbyEelFarmCommon_EelFarmSnAnd()
}
