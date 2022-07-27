package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.WatertankInfo;
import com.cuuva.springboot.repository.WatertankInfoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/water")
public class WatertankInfoController {

    private final WatertankInfoRepository watertankInfoRepository;

    @GetMapping
    public List<WatertankInfo> getList(@Param("number") Integer eelFarmSn) {
        return watertankInfoRepository.findAllByEelFarmCommonEelFarmSn(eelFarmSn);
    }
}