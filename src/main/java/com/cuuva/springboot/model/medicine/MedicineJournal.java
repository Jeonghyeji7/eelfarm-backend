package com.cuuva.springboot.model.medicine;

import com.cuuva.springboot.model.WatertankInfo;
import com.cuuva.springboot.model.LineInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "ef_medicine_journal")
public class MedicineJournal {

	@Id
	@Comment("약욕대장일련번호")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicine_sn", length = 11)
	private Integer medicineSn;

	@ManyToOne
	@JoinColumn(name = "medicine_manage_sn", referencedColumnName = "medicine_manage_sn")
	private MedicineManageJournal medicineManageJournal;

	@ManyToOne
	@Comment("약품일련번호")
	@JoinColumn(name = "medicine_species_sn", referencedColumnName = "medicine_species_sn")
	private MedicineSpecies medicineSpecies;

	@Comment("날짜")
	@Column(name = "medicine_journal_dt")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private LocalDate medicineJournalDt;

	@Comment("라인일련번호")
	@ManyToOne
	@JoinColumn(name = "line_sn", referencedColumnName = "line_sn")
	private LineInfo lineInfo;

	@Comment("수조 일련번호")
	@ManyToOne
	@JoinColumn(name = "watertank_sn", referencedColumnName = "watertank_sn")
	private WatertankInfo waterInfo;

	@Comment("회차")
	@Column(name = "medicine_inject_order",length = 11)
	private Integer medicineInjectOrder;

	@Comment("메모")
	@Column(name = "medicine_inject_note",length = 50)
	private String medicineInjectNote;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
			return false;
		}
		MedicineJournal that = (MedicineJournal) o;
		return medicineSn != null && Objects.equals(medicineSn, that.medicineSn);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
