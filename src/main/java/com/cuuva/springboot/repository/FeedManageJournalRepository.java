package com.cuuva.springboot.repository;

import com.cuuva.springboot.model.feed.FeedManageJournal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FeedManageJournalRepository extends JpaRepository<FeedManageJournal, Integer>{
    FeedManageJournal findByFeedManageJournalDtAndEelFarmCommonEelFarmSn(
        LocalDate feedManageJournalDt, Integer eelFarmSn);

    @Query(value =
        "SELECT "
            + "* "
            + "FROM ef_feed_manage_journal "
            + "WHERE YEAR(feed_manage_journal_dt) = ?1 AND MONTH(feed_manage_journal_dt) = ?2 AND eel_farm_sn=?3",
        nativeQuery = true
    )
    List<FeedManageJournal> findWithNativeQuery1(
        String year, String month, Integer eelFarmSn
    );

    @Query(value =
        "SELECT "
            + "feed_manage_journal_dt "
            + "FROM ef_feed_manage_journal "
            + "WHERE eel_farm_sn = ?1",
        nativeQuery = true
    )
    List<String> findWithNativeQuery2(Integer eelFarmSn);


    @Query(value =
        "SELECT "
            + "DISTINCT MONTH(feed_manage_journal_dt) AS month "
            + "FROM ef_feed_manage_journal "
            + "WHERE YEAR(feed_manage_journal_dt) = ?1 AND eel_farm_sn = ?2",
        nativeQuery = true
    )
    List<String> findWithNativeQuery3(String year, Integer eelFarmSn);
}
