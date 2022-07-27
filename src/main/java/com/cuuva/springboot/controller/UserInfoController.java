package com.cuuva.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuuva.springboot.model.UserInfo;
import com.cuuva.springboot.repository.UserInfoRepository;
import com.cuuva.springboot.repository.mapping.UserInfoMapping;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class UserInfoController {

    @Autowired
    private UserInfoRepository userinfoRepository;

    @GetMapping("/userinfo")
    public List<UserInfo> getAllUserInfo(){
        return userinfoRepository.findAll();
    }

    @GetMapping("/userinfo/in")
    public List <UserInfoMapping> findByUserIdAndUserPassword(@Param("id") String userId,@Param("password") String userPassword){
        return userinfoRepository.findByUserIdAndUserPassword(userId,userPassword);
    }
}
