package com.cuuva.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Comment;


@Entity
@Table(name = "eel_farm_common")
public class EelFarmCommon {
	@Id
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
}
