package com.cuuva.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuuva.springboot.model.out.OutManageJournal;

public interface OutManageJournalRepository extends JpaRepository<OutManageJournal, Integer>{

	//List<OutManageJournal> findByEelFarmSn(Integer eelFarmSn);

//	Optional<OutManageJournal>findByOutManageJournalYearAndOutManageJournalMonthAndEelFarmCommon_EelFarmSn(@Param("year") String OutManageJournalYear,@Param("month") String OutManageJournalMonth,@Param("number") Integer eelFarmSn);
//
//    Optional<OutManageJournal> findByEelFarmCommon_EelFarmSn(@Param("number") Integer eelFarmSn);
//
//    Optional<OutManageJournal> findByOutManageJournalYearAndEelfAndEelFarmCommon_EelFarmSn(@Param("year") String OutManageJournalYear,@Param("number") Integer eelFarmSn);

}
