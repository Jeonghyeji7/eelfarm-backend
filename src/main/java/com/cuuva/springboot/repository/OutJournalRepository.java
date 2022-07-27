package com.cuuva.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuuva.springboot.model.out.OutJournal;

public interface OutJournalRepository extends JpaRepository<OutJournal, Integer>{


	//OutJournal findbyEelFarmCommon_EelFarmSnAndOutJournalSn(Integer eelFarmSn,Integer outJournalSn);

	//Optional<OutJournal> findbyEelFarmCommon_EelFarmSnAnd()
}
