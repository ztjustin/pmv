package com.pmv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmv.entity.Platform;

@Repository("platformJpaRepository")
public interface PlatformJpaRepository extends JpaRepository<Platform,Serializable> {
	
	

}
