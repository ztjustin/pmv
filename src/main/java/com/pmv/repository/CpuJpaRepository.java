package com.pmv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmv.entity.Cpu;

@Repository("cpuJpaRepository")
public interface CpuJpaRepository extends JpaRepository<Cpu,Serializable>  {
	
	

}
