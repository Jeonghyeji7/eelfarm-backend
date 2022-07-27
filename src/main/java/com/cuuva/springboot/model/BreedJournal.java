package com.cuuva.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "ef_breed_journal")
public class BreedJournal {

	@Comment("일지 일련번호")
	@Id
	@Column(name = "breed_journal_sn")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long breedJournalSn;

	@Comment("양반장일련번호")
	@ManyToOne
	@JoinColumn(name = "eel_farm_sn", referencedColumnName = "eel_farm_sn")
	private EelFarmCommon eelFarmCommon;

	@ManyToOne
	@JoinColumn(name = "line_sn", referencedColumnName = "line_sn")
	@Comment("라인일련번호")
	private LineInfo lineInfo;

	@ManyToOne
	@JoinColumn(name = "watertank_sn", referencedColumnName = "watertank_sn")
	@Comment("수조 일련번호")
	private WatertankInfo watertankInfo;

	@Comment("사육일지 날짜")
	@Column(name = "breed_journal_dt", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private LocalDate breedJournalDt;

	@Comment("전일총마리수")
	@Column(name = "prev_breed_count")
	private Integer prevBreedCount;

	@Comment("전일어체중")
	@Column(name = "prev_weight")
	private Integer prevWeight;

	@Comment("오전사료량")
	@Column(name = "feed_quantity_am", precision=10, scale=2)
	private BigDecimal feedQuantityAm;

	@Comment("오후사료량")
	@Column(name = "feed_quantity_pm", precision=10, scale=2)
	private BigDecimal feedQuantityPm;

	@Comment("오전사료량+오후사료량")
	@Column(name = "feed_quantity_sum", precision=10, scale=2)
	private BigDecimal feedQuantitySum;

	@Comment("효율(%)")
	@Column(name = "efficiency")
	private Integer efficiency;

	@Comment("사료 합계 * 효율(%)=증육량")
	@Column(name = "growth", precision=5, scale=2)
	private BigDecimal growth;

	@Comment("현재 마리수")
	@Column(name = "breed_count")
	private Integer breedCount;

	@Comment("전일 어체중 + 증육량 = 어체중")
	@Column(name = "weight")
	private Integer weight;

	@Comment("현재 개체수 / 어체중 = 평균미수")
	@Column(name = "average_weight", precision = 5, scale = 2)
	private BigDecimal averageWeight;

	@Comment("표준 급이율(%)")
	@Column(name = "standard_rate", precision = 5, scale = 2)
	private BigDecimal standardRate;

	@Comment("표준 사료량")
	@Column(name = "standard_feed", precision = 5, scale = 2)
	private BigDecimal standardFeed;

	@Comment("사료 합계 / 표준 사료량 = 비율")
	@Column(name = "standard_ratio")
	private Integer standardRatio;

	@Comment("전일 총 사료량")
	@Column(name = "prev_total_feed", precision = 10, scale = 2)
	private BigDecimal prevTotalFeed;

	@Comment("전일 총사료량 + 사료 합계 = 총사료량")
	@Column(name = "total_feed", precision = 10, scale = 2)
	private BigDecimal totalFeed;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
			return false;
		}
		BreedJournal that = (BreedJournal) o;
		return breedJournalSn != null && Objects.equals(breedJournalSn, that.breedJournalSn);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
