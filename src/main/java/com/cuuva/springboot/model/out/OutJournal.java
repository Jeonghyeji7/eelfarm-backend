package com.cuuva.springboot.model.out;

import com.cuuva.springboot.model.EelSpeciesInfo;
import com.cuuva.springboot.model.WatertankInfo;
import com.cuuva.springboot.model.LineInfo;
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
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@Setter
@Table(name = "ef_out_journal")
public class OutJournal {

	@Id
	@Comment("출하대장일련번호")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "out_journal_sn", length = 11)
	private Integer outJournalSn;

	@ManyToOne
	@JoinColumn(name = "out_manage_journal_sn", referencedColumnName = "out_manage_journal_sn")
	private OutManageJournal outManageJournal;

	@Column(name = "out_dt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	@Comment("날짜")
	private LocalDate outDt;

	@Comment("라인일련번호")
	@ManyToOne
	@JoinColumn(name = "line_sn", referencedColumnName = "line_sn")
	private LineInfo lineInfo;

	@Comment("수조 일련번호")
	@ManyToOne
	@JoinColumn(name = "watertank_sn", referencedColumnName = "watertank_sn")
	private WatertankInfo waterInfo;

	@ManyToOne
	@JoinColumn(name = "eel_species_sn", referencedColumnName = "eel_species_sn")
	private EelSpeciesInfo eelSpeciesInfo;

	@Comment("무게")
	@Column(name = "out_weight",length = 11)
	private Integer outWeight;

	@Comment("출하대장평균미수")
	@Column(name = "out_average_weight", precision = 5, scale = 2)
	private BigDecimal outAverageWeight;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
			return false;
		}
		OutJournal that = (OutJournal) o;
		return outJournalSn != null && Objects.equals(outJournalSn, that.outJournalSn);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
