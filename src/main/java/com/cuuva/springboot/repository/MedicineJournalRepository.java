package com.cuuva.springboot.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cuuva.springboot.model.MedicineJournal;
import com.fasterxml.jackson.annotation.JsonFormat;

@Repository
public interface MedicineJournalRepository extends JpaRepository<MedicineJournal,Integer>{
	
	
	//SELECT DISTINCT date_format(medicine_manage_journal_dt, "%m") AS month FROM ef_medicine_journal WHERE YEAR(medicine_manage_journal_dt)=?
	//@Query(value = "SELECT DISTINCT date_format(medicine_manage_journal_dt, \"%m\") AS month FROM ef_medicine_journal WHERE YEAR(medicine_manage_journal_dt)=?", nativeQuery = true)
	//public List<MedicineJournal> selectYearMonth(@Param(value = "year") String year,@Param(value = "month") String month);

}
