package com.cuuva.springboot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cuuva.springboot.model.medicine.MedicineManageJournal;
import org.springframework.data.jpa.repository.Query;

public interface MedicineManageJournalRepository extends JpaRepository<MedicineManageJournal, Integer> {
    List<MedicineManageJournal> findAllByMedicineManageJournalYearAndMedicineManageJournalMonthAndEelFarmCommonEelFarmSn(
        String medicineManageJournalYear, String medicineManageJournalMonth, Integer eelFarmSn
    );

    @Query(value =
        "SELECT "
            + "medicine_manage_journal_month "
            + "FROM ef_medicine_manage_journal "
            + "WHERE medicine_manage_journal_year=?1 AND eel_farm_sn=?2",
        nativeQuery = true
    )
    List<String> findWithNativeQuery1(String medicineManageJournalYear, Integer eelFarmSn);


    @Query(value =
        "SELECT "
            + "DISTINCT medicine_manage_journal_year "
            + "FROM ef_medicine_manage_journal "
            + "WHERE eel_farm_sn=?1",
        nativeQuery = true
    )
    List<String> findWithNativeQuery2(Integer eelFarmSn);
}
