package com.cuuva.springboot.model.feed;

import com.cuuva.springboot.model.EelFarmCommon;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "ef_feed_manage_journal",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {
						"feed_manage_journal_dt",
				})
		})
public class FeedManageJournal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feed_manage_journal_sn", length = 11)
	private Integer feedManageJournalSn;

	@Comment("날짜")
	@Column(name = "feed_manage_journal_dt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private LocalDate feedManageJournalDt;

	@Comment("양만장 일련 번호")
	@ManyToOne
	@JoinColumn(name = "eel_farm_sn", referencedColumnName = "eel_farm_sn")
	private EelFarmCommon eelFarmCommon;

	@OneToMany
	@JoinColumn(name = "feed_manage_journal_sn", referencedColumnName = "feed_manage_journal_sn")
	private List<FeedJournal> feedJournalList;
}
