package com.cuuva.springboot.model.feed;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
public class FeedJournalDTO {
	private Integer feedJournalSn;
	private Feed feed;
	private String lineSn;
	private BigDecimal feedIn;
	private BigDecimal feedOut;
	private BigDecimal prevFeedStock;
	private BigDecimal feedStock;
	private BigDecimal feedLost;

	public FeedJournalDTO(FeedJournal feedJournal) {
		this.feedJournalSn = feedJournal.getFeedJournalSn();
		this.feed = feedJournal.getFeed();
		this.lineSn = feedJournal.getLineSn();
		this.feedIn = feedJournal.getFeedIn();
		this.feedOut = feedJournal.getFeedOut();
		this.prevFeedStock = feedJournal.getPrevFeedStock();
		this.feedStock = feedJournal.getFeedStock();
		this.feedLost = feedJournal.getFeedLost();
	}
}
