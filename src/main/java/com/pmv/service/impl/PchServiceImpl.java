package com.pmv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmv.entity.Pch;
import com.pmv.repository.PchJpaRepository;
import com.pmv.service.PchService;

@Service("pchServiceImpl")
public class PchServiceImpl implements PchService{
	
	@Autowired
	@Qualifier("pchJpaRepository")
	private PchJpaRepository pchJpaRepository;

	@Override
	public List<Pch> getAll() {
		return pchJpaRepository.findAll();
	}

	@Override
	public Pch getOne(Long pchId) {
		return pchJpaRepository.getOne(pchId);
	}
	
	@Override
	public Pch addOne(Pch pch) {
		return pchJpaRepository.save(pch);
	}
	
	@Override
	public void delete(Long pchId) {
		pchJpaRepository.deleteById(pchId);	
	}

	@Override
	public boolean exists(Long pchId) {
		return pchJpaRepository.existsById(pchId);
	}

}
