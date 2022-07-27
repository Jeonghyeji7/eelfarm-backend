package com.cuuva.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(
		name = "ef_medicine_manage_journal",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {
						"eel_farm_sn",
						"medicine_manage_journal_year",
						"medicine_manage_journal_month"
				})
		}
)
public class MedicineManageJournal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicine_manage_sn", length = 11)
	private Integer medicineManageSn;

	@Comment("연도")
	@Column(name = "medicine_manage_journal_year", length = 50)
	private String medicineManageJournalYear;

	@Comment("월날짜")
	@Column(name = "medicine_manage_journal_month", length = 50)
	private String medicineManageJournalMonth;

	@Comment("양만장 일련 번호")
	@ManyToOne
	@JoinColumn(name = "eel_farm_sn", referencedColumnName = "eel_farm_sn")
	private EelFarmCommon eelFarmCommon;
}
