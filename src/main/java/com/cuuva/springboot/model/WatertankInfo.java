package com.cuuva.springboot.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ef_watertank_info")
public class WatertankInfo {

	@Comment("수조번호")
	@Id
	@Column(name = "watertank_sn")
	private Integer watertankSn;

	@Comment("양반장일련번호")
	@ManyToOne
	@JoinColumn(name = "eel_farm_sn", referencedColumnName = "eel_farm_sn")
	private EelFarmCommon eelFarmCommon;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
			return false;
		}
		WatertankInfo waterInfo = (WatertankInfo) o;
		return watertankSn != null && Objects.equals(watertankSn, waterInfo.watertankSn);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
