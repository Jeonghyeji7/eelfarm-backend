package com.cuuva.springboot.repository;

import com.cuuva.springboot.model.feed.FeedJournal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedJournalRepository extends JpaRepository<FeedJournal, Integer> {
    List<FeedJournal> findAllByFeedManageJournalFeedManageJournalSn(
        Integer feedManageJournalSn);
}
