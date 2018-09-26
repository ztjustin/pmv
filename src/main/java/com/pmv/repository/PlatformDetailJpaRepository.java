package com.pmv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmv.entity.PlatformDetail;

@Repository("platformDetailJpaRepository")
public interface PlatformDetailJpaRepository extends JpaRepository<PlatformDetail, Serializable> {
	
	

}
