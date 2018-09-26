package com.pmv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmv.entity.Pch;

@Repository("pchJpaRepository")
public interface PchJpaRepository extends JpaRepository<Pch,Serializable> {
	

}
