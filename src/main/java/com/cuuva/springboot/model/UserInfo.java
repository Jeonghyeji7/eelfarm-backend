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
@Table(name = "user_info")
public class UserInfo {
	@Comment("사용자 일련번호")
	@Id
	@Column(name = "user_sn", length = 11)
	private Integer userSn;

	@Comment("아이디")
	@Column(name = "user_id", length = 50, unique = true)
	private String userId;

	@Comment("비밀번호")
	@Column(name = "user_password")
	private String userPassword;

	@Comment("양반장일련번호")
	@ManyToOne
	@JoinColumn(name = "eel_farm_sn")
	private EelFarmCommon eelFarmCommon;

	@Comment("담당자")
	@Column(name = "user_name", length = 50)
	private String userName;

	@Comment("전화번호")
	@Column(name = "user_phone_number", length = 50)
	private String userPhoneNumber;

	@Comment("이메일")
	@Column(name = "user_email", length = 50)
	private String userEmail;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
			return false;
		}
		UserInfo userInfo = (UserInfo) o;
		return userId != null && Objects.equals(userId, userInfo.userId);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
