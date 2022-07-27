package com.cuuva.springboot.repository;

import com.cuuva.springboot.model.LineInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineInfoRepository extends JpaRepository<LineInfo, Integer> {
	List<LineInfo> findAllByEelFarmCommonEelFarmSn(Integer eelFarmSn);
}
