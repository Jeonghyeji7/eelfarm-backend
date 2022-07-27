package com.cuuva.springboot.model.medicine;

import com.cuuva.springboot.model.EelFarmCommon;
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
@Table(name = "ef_medicine_species_info")
public class MedicineSpecies {

	@Comment("약품일련번호")
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicine_species_sn", length = 11)
	private Integer medicineSpeciesSn;

	@Comment("양반장일련번호")
	@ManyToOne
	@JoinColumn(name = "eel_farm_sn", referencedColumnName = "eel_farm_sn")
	private EelFarmCommon eelFarmCommon;

	@Comment("약품명")
	@Column(name = "medicine_name", length = 50)
	private String medicineName;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
			return false;
		}
		MedicineSpecies that = (MedicineSpecies) o;
		return medicineSpeciesSn != null && Objects.equals(medicineSpeciesSn,
				that.medicineSpeciesSn);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
