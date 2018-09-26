package com.pmv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmv.entity.OperatingSystem;

@Repository("operatingSystemJpaRepository")
public interface OperatingSystemJpaRepository extends JpaRepository<OperatingSystem, Serializable> {
	

}
