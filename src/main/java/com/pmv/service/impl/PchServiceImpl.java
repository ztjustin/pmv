package com.pmv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.pmv.entity.Pch;
import com.pmv.repository.PchJpaRepository;
import com.pmv.service.PchService;

public class PchServiceImpl implements PchService{
	
	@Autowired
	@Qualifier("pchJpaRepository")
	private PchJpaRepository pchJpaRepository;

	@Override
	public List<Pch> getAll() {
		return pchJpaRepository.findAll();
	}

	@Override
	public Pch getOne(int pchId) {
		return pchJpaRepository.getOne(pchId);
	}

	@Override
	public Pch addOne(Pch pch) {
		return pchJpaRepository.saveAndFlush(pch);
	}

	@Override
	public void delete(int pchId) {
		pchJpaRepository.deleteById(pchId);
		
	}

}
