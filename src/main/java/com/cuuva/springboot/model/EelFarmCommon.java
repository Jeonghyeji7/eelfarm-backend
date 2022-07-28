package com.cuuva.springboot.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "eel_farm_common")
public class EelFarmCommon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eel_farm_sn",length = 11)
	@Comment("양만장 일련 번호")
	private Integer eelFarmSn;

	@Comment("양만장 상호명")
	@Column(name = "eel_farm_name",length = 50)
	private String eelFarmName;

	@Comment("양만장 주소")
	@Column(name = "eel_farm_address",length = 50)
	private String eelFarmAddress;

	@Comment("양만장 대표전화번호")
	@Column(name = "eel_farm_phone_number",length = 50)
	private String eelFarmPhoneNumber;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(
			o)) {
			return false;
		}
		EelFarmCommon that = (EelFarmCommon) o;
		return eelFarmSn != null && Objects.equals(eelFarmSn, that.eelFarmSn);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
