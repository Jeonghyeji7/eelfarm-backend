package com.cuuva.springboot.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuuva.springboot.model.FeedManageJournal;

public interface FeedManageJournalRepository extends JpaRepository<FeedManageJournal, Integer>{

}
