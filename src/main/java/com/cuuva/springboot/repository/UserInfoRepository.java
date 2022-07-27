package com.cuuva.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cuuva.springboot.model.EelFarmCommon;
import com.cuuva.springboot.model.UserInfo;
import com.cuuva.springboot.repository.mapping.UserInfoMapping;

public interface UserInfoRepository extends JpaRepository<UserInfo,String>{

//	@GetMapping("/breedjournal/pre")
//	public List<BreedJournal> findByDateAndLineAndWater(@Param("breed_journal_dt") @DateTimeFormat(iso = ISO.DATE) LocalDate breed_journal_dt,@Param("line_sn") Integer line_sn,@Param("watertank") Integer watertank){
//		return breedjournalRepository.findByDateAndLineAndWater(breed_journal_dt,line_sn,watertank);
//	}

//	@Query(value = "SELECT projectId, projectName FROM project", nativeQuery = true)
//    List<ProjectMini> findAllProjectsMini();

	//Page <UserInfoMapping> findByUser(Pageable pageable);

	List <UserInfoMapping> findByUserIdAndUserPassword(String userId,String userPassword);
};
