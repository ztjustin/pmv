package com.pmv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmv.entity.Itp;

@Repository("itpJpaRepository")
public interface ItpJpaRepository extends JpaRepository<Itp, Serializable> {
	
	

}
