package com.cuuva.springboot.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "ef_eel_species_info")
public class EelSpeciesInfo {

	@Comment("장어품종일련번호")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eel_species_sn", length = 11)
	private Integer eelSpeciesSn;

	@Comment("양반장일련번호")
	@ManyToOne
	@JoinColumn(name = "eel_farm_sn", referencedColumnName = "eel_farm_sn")
	private EelFarmCommon eelFarmCommon;

	@Comment("장어품종")
	@Column(name = "eel_species_name", length = 50)
	private String eelSpeciesName;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
			return false;
		}
		EelSpeciesInfo that = (EelSpeciesInfo) o;
		return eelSpeciesSn != null && Objects.equals(eelSpeciesSn, that.eelSpeciesSn);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
