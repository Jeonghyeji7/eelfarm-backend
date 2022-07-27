package com.cuuva.springboot.repository;

import com.cuuva.springboot.model.breed.BreedJournal;
import com.cuuva.springboot.model.breed.BreedJournalTotal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedJournalRepository extends JpaRepository<BreedJournal, Integer>{
    List<BreedJournal> findAllByBreedJournalDtAndLineInfoLineSnAndEelFarmCommonEelFarmSn(LocalDate breedJournalDt, Integer lineSn, Integer eelFarmSn);

    List<BreedJournal> findAllByBreedJournalDtAndEelFarmCommonEelFarmSn(LocalDate breedJournalDt, Integer eelFarmSn);

    List<BreedJournal> findAllByBreedJournalDtAndLineInfoLineSnAndWatertankInfoWatertankSnAndEelFarmCommonEelFarmSn(LocalDate breedJournalDt, Integer lineSn, Integer watertankSn, Integer eelFarmSn);

    @Query(value =
        "SELECT "
            + "SUM(prev_breed_count) AS preCount, "
            + "SUM(prev_weight) AS preWeight, "
            + "SUM(feed_quantity_am) AS feedAm, "
            + "SUM(feed_quantity_pm) AS feedPm, "
            + "SUM(feed_quantity_sum) AS feedSum, "
            + "SUM(breed_count) as count, "
            + "SUM(weight) AS weight, "
            + "SUM(average_weight) as av_weight, "
            + "SUM(standard_feed) as s_feed, "
            + "SUM(prev_total_feed) AS pretotalfeed, "
            + "SUM(total_feed) AS totalfeed "
            + "FROM ef_breed_journal "
            + "WHERE breed_journal_dt=?1 AND line_sn=?2 AND eel_farm_sn=?3"
        , nativeQuery = true
    )
    BreedJournalTotal findWithNativeQuery(LocalDate breedJournalDt, Integer lineSn, Integer eelFarmSn);

    @Modifying
    @Query(value =
        "UPDATE ef_breed_journal "
            + "SET "
            + "prev_breed_count = :#{#breedJournal.prevBreedCount}, "
            + "prev_weight = :#{#breedJournal.prevWeight}, "
            + "prev_total_feed = :#{#breedJournal.prevTotalFeed} "
            + "WHERE "
            + "breed_journal_dt = :#{#breedJournal.breedJournalDt} AND "
            + "line_sn = :#{#breedJournal.lineInfo.lineSn} AND "
            + "eel_farm_sn = :#{#breedJournal.eelFarmCommon.eelFarmSn}"
        , nativeQuery = true
    )
    BreedJournal saveWithNativeQuery(@Param("breedJournal") BreedJournal breedJournal);
}
