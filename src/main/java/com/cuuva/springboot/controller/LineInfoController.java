package com.cuuva.springboot.controller;

import com.cuuva.springboot.model.LineInfo;
import com.cuuva.springboot.repository.LineInfoRepository;
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
@RequestMapping("/line")
public class LineInfoController {

    private final LineInfoRepository lineInfoRepository;

    @GetMapping
    public List<LineInfo> getList(@RequestParam("number") Integer eelFarmSn) {
        return lineInfoRepository.findAllByEelFarmCommonEelFarmSn(eelFarmSn);
    }
}
