package com.cuuva.springboot.repository;

import com.cuuva.springboot.model.out.OutJournal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutJournalRepository extends JpaRepository<OutJournal, Integer>{
    List<OutJournal> findAllByOutManageJournalOutManageJournalSn(Integer outManageJournalSn);
}
