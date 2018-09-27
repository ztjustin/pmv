package com.pmv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmv.entity.User;

@Repository("userJpaRepository")
public interface UserJpaRepository extends JpaRepository<User, Serializable> {
	
	public abstract User findByUserName(String userName);
}
