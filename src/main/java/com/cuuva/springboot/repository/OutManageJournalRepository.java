package com.cuuva.springboot.repository;

import com.cuuva.springboot.model.out.OutManageJournal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OutManageJournalRepository extends JpaRepository<OutManageJournal, Integer>{
    List<OutManageJournal> findAllByOutManageJournalYearAndOutManageJournalMonthAndEelFarmCommonEelFarmSn(
        String outManageJournalYear, String outManageJournalMonth, Integer eelFarmSn
    );

    @Query(value =
        "SELECT "
            + "out_manage_journal_month "
            + "FROM ef_out_manage_journal "
            + "WHERE out_manage_journal_year=?1 AND eel_farm_sn=?2",
        nativeQuery = true
    )
    List<String> findWithNativeQuery1(String outManageJournalYear, Integer eelFarmSn);


    @Query(value =
        "SELECT "
            + "DISTINCT out_manage_journal_year "
            + "FROM ef_out_manage_journal "
            + "WHERE eel_farm_sn=?1",
        nativeQuery = true
    )
    List<String> findWithNativeQuery2(Integer eelFarmSn);
}
