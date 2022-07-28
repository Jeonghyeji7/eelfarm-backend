package com.cuuva.springboot.model.medicine;

import com.cuuva.springboot.model.LineInfo;
import com.cuuva.springboot.model.WatertankInfo;
import java.time.LocalDate;
import lombok.Data;

@Data
public class MedicineJournalDTO {
	private Integer medicineSn;
	private MedicineSpecies medicineSpecies;
	private LocalDate medicineJournalDt;
	private LineInfo lineInfo;
	private WatertankInfo waterInfo;
	private Integer medicineInjectOrder;
	private String medicineInjectNote;

	public MedicineJournalDTO(MedicineJournal medicineJournal) {
		this.medicineSn = medicineJournal.getMedicineSn();
		this.medicineSpecies = medicineJournal.getMedicineSpecies();
		this.medicineJournalDt = medicineJournal.getMedicineJournalDt();
		this.lineInfo = medicineJournal.getLineInfo();
		this.waterInfo = medicineJournal.getWaterInfo();
		this.medicineInjectOrder = medicineJournal.getMedicineInjectOrder();
		this.medicineInjectNote = medicineJournal.getMedicineInjectNote();
	}
}
