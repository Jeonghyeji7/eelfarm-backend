package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.Login;
import com.cuuva.springboot.model.UserInfo;
import com.cuuva.springboot.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = {"http://210.217.121.58:28080", "http://192.168.10.11:3000", "http://localhost:3000"})
@RestController
@RequestMapping("/login")
public class UserController {

    private final UserInfoRepository userinfoRepository;

    @PostMapping
    public UserInfo postLogin(
        @RequestBody Login login
    ){
        return userinfoRepository.findByUserIdAndUserPassword(login.getUserId(), login.getUserPassword());
    }
}
