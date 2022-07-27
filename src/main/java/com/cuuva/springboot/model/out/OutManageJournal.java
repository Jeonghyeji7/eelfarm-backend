package com.cuuva.springboot.model.out;

import com.cuuva.springboot.model.EelFarmCommon;
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
		name = "ef_out_manage_journal",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {
						"eel_farm_sn",
						"out_manage_journal_year",
						"out_manage_journal_month"
				})
		}
)
public class OutManageJournal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "out_manage_journal_sn", length = 11)
	private Integer outManageJournalSn;

	@Comment("연도")
	@Column(name = "out_manage_journal_year", length = 50)
	private String outManageJournalYear;

	@Comment("월날짜")
	@Column(name = "out_manage_journal_month", length = 50)
	private String outManageJournalMonth;

	@Comment("양만장 일련 번호")
	@ManyToOne
	@JoinColumn(name = "eel_farm_sn", referencedColumnName = "eel_farm_sn")
	private EelFarmCommon eelFarmCommon;
}
