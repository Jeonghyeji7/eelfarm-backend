package com.cuuva.springboot.repository;

import com.cuuva.springboot.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{
	UserInfo findByUserIdAndUserPassword(String userId, String userPassword);
};
