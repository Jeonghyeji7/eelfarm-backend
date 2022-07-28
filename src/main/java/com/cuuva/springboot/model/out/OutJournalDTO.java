package com.cuuva.springboot.model.out;

import com.cuuva.springboot.model.EelSpeciesInfo;
import com.cuuva.springboot.model.LineInfo;
import com.cuuva.springboot.model.WatertankInfo;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class OutJournalDTO {
	private Integer outJournalSn;
	private LocalDate outDt;
	private LineInfo lineInfo;
	private WatertankInfo waterInfo;
	private EelSpeciesInfo eelSpeciesInfo;
	private Integer outWeight;
	private BigDecimal outAverageWeight;

	public OutJournalDTO(OutJournal outJournal) {
		this.outJournalSn = outJournal.getOutJournalSn();
		this.outDt = outJournal.getOutDt();
		this.lineInfo = outJournal.getLineInfo();
		this.waterInfo = outJournal.getWaterInfo();
		this.eelSpeciesInfo = outJournal.getEelSpeciesInfo();
		this.outWeight = outJournal.getOutWeight();
		this.outAverageWeight = outJournal.getOutAverageWeight();
	}
}
