package com.cuuva.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuuva.springboot.model.medicine.MedicineJournal;

@Repository
public interface MedicineJournalRepository extends JpaRepository<MedicineJournal, Integer>{

}
