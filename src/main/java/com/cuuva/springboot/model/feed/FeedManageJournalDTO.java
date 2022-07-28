package com.cuuva.springboot.model.feed;

import com.cuuva.springboot.model.EelFarmCommon;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FeedManageJournalDTO {
	private Integer feedManageJournalSn;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private LocalDate feedManageJournalDt;
	private EelFarmCommon eelFarmCommon;
	private List<FeedJournalDTO> feedJournalList;

	public FeedManageJournalDTO(FeedManageJournal feedManageJournal) {
		this.feedManageJournalSn = feedManageJournal.getFeedManageJournalSn();
		this.feedManageJournalDt = feedManageJournal.getFeedManageJournalDt();
		this.eelFarmCommon = feedManageJournal.getEelFarmCommon();

		feedJournalList = new ArrayList<>();

		if (feedManageJournal.getFeedJournalList() != null) {
			for (FeedJournal feedJournal : feedManageJournal.getFeedJournalList()) {
				feedJournalList.add(new FeedJournalDTO(feedJournal));
			}
		}
	}
}
