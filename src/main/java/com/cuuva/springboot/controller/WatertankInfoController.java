package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.WatertankInfo;
import com.cuuva.springboot.repository.WatertankInfoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = {"http://210.217.121.58:28080", "http://192.168.10.11:3000", "http://localhost:3000"})
@RestController
@RequestMapping("/water")
public class WatertankInfoController {

    private final WatertankInfoRepository watertankInfoRepository;

    @GetMapping
    public List<WatertankInfo> getList(@RequestParam("number") Integer eelFarmSn) {
        return watertankInfoRepository.findAllByEelFarmCommonEelFarmSn(eelFarmSn);
    }
}
