package com.cuuva.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuuva.springboot.model.medicine.MedicineManageJournal;

public interface MedicineManageJournalRepository extends JpaRepository<MedicineManageJournal, Integer> {

}
