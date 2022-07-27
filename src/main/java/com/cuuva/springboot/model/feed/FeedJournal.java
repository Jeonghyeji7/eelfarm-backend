package com.cuuva.springboot.model.feed;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "ef_feed_journal")
public class FeedJournal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feed_journal_sn", length = 11)
	private Integer feedJournalSn;

	@Comment("사료코드")
	@ManyToOne
	@JoinColumn(name = "feed_code", referencedColumnName = "feed_code")
	private Feed feed;

	@Comment("라인")
	@Column(name = "line_sn", length = 50)
	private String lineSn;

	@ManyToOne
	@JoinColumn(name = "feed_manage_journal_sn", referencedColumnName = "feed_manage_journal_sn")
	private FeedManageJournal feedManageJournal;

	@Comment("입고량")
	@Column(name = "feed_in",precision=20, scale=2)
	private BigDecimal feedIn;

	@Comment("출고량")
	@Column(name = "feed_out",precision=20, scale=2)
	private BigDecimal feedOut;

	@Comment("전일 재고량")
	@Column(name = "prev_feed_stock",precision=20, scale=2)
	private BigDecimal prevFeedStock;

	@Comment("재고량")
	@Column(name = "feed_stock",precision=20, scale=2)
	private BigDecimal feedStock;

	@Comment("망실")
	@Column(name = "feed_lost",precision=20, scale=2)
	private BigDecimal feedLost;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
			return false;
		}
		FeedJournal that = (FeedJournal) o;
		return feedManageJournal != null && Objects.equals(feedManageJournal,
				that.feedManageJournal);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
