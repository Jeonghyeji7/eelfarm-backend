package com.cuuva.springboot.model.medicine;

import com.cuuva.springboot.model.EelFarmCommon;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class MedicineManageJournalDTO {
	private Integer medicineManageSn;
	private String medicineManageJournalYear;
	private String medicineManageJournalMonth;
	private EelFarmCommon eelFarmCommon;
	private List<MedicineJournalDTO> medicineJournalList;

	public MedicineManageJournalDTO(MedicineManageJournal medicineManageJournal) {
		this.medicineManageSn = medicineManageJournal.getMedicineManageSn();
		this.medicineManageJournalYear = medicineManageJournal.getMedicineManageJournalYear();
		this.medicineManageJournalMonth = medicineManageJournal.getMedicineManageJournalMonth();
		this.eelFarmCommon = medicineManageJournal.getEelFarmCommon();

		medicineJournalList = new ArrayList<>();

		if (medicineManageJournal.getMedicineJournalList() != null) {
			for (MedicineJournal medicineJournal : medicineManageJournal.getMedicineJournalList()) {
				medicineJournalList.add(new MedicineJournalDTO(medicineJournal));
			}
		}
	}
}
