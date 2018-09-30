package com.pmv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmv.entity.HardDisk;

@Repository("hardDiskJpaRepository")
public interface HardDiskJpaRepository extends JpaRepository<HardDisk, Serializable> {
	

}
