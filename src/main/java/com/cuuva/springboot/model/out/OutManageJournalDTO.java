package com.cuuva.springboot.model.out;

import com.cuuva.springboot.model.EelFarmCommon;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class OutManageJournalDTO {
	private Integer outManageJournalSn;
	private String outManageJournalYear;
	private String outManageJournalMonth;
	private EelFarmCommon eelFarmCommon;
	private List<OutJournalDTO> outJournalList;

	public OutManageJournalDTO(OutManageJournal outManageJournal) {
		this.outManageJournalSn = outManageJournal.getOutManageJournalSn();
		this.outManageJournalYear = outManageJournal.getOutManageJournalYear();
		this.outManageJournalMonth = outManageJournal.getOutManageJournalMonth();
		this.eelFarmCommon = outManageJournal.getEelFarmCommon();

		outJournalList = new ArrayList<>();

		for (OutJournal outJournal : outManageJournal.getOutJournalList()) {
			outJournalList.add(new OutJournalDTO(outJournal));
		}
	}
}
