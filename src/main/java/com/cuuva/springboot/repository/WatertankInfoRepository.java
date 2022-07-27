package com.cuuva.springboot.repository;

import com.cuuva.springboot.model.WatertankInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatertankInfoRepository extends JpaRepository<WatertankInfo, Integer> {
	List<WatertankInfo> findAllByEelFarmCommonEelFarmSn(Integer eelFarmSn);
}
