package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.LineInfo;
import com.cuuva.springboot.model.Login;
import com.cuuva.springboot.model.UserInfo;
import com.cuuva.springboot.repository.LineInfoRepository;
import com.cuuva.springboot.repository.UserInfoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/line")
public class LineInfoController {

    private final LineInfoRepository lineInfoRepository;

    @GetMapping
    public List<LineInfo> getList(@Param("number") Integer eelFarmSn) {
        return lineInfoRepository.findAllByEelFarmCommonEelFarmSn(eelFarmSn);
    }
}
