package com.cuuva.springboot.model;

import java.io.Serializable;

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
import org.hibernate.annotations.Comment;

@Getter
@Setter
@Entity
@Table(name = "ef_feed")
public class Feed {
	@Comment("사료 코드")
	@Id
	@Column(name = "feed_code", length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedCode;

	@Comment("양반장일련번호")
	@ManyToOne
	@JoinColumn(name = "eel_farm_sn", referencedColumnName = "eel_farm_sn")
	private EelFarmCommon eelFarmCommon;

	@Comment("사료 규격(양)")
	@Column(name = "feed_standard")
	private Integer feedStandard;

	@Comment("사료 구매처")
	@Column(name = "feed_seller_code", length = 50)
	private String feedSellerCode;

	@Comment("사료 명")
	@Column(name = "feed_name", length = 50)
	private String feedName;
}
