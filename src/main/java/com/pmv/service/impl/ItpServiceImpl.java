package com.pmv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmv.entity.Itp;
import com.pmv.repository.ItpJpaRepository;
import com.pmv.service.ItpService;

@Service("itpServiceImpl")
public class ItpServiceImpl implements ItpService {
	
	@Autowired
	@Qualifier("itpJpaRepository")
	private ItpJpaRepository itpJpaRepository;

	@Override
	public List<Itp> getAll() {
		return itpJpaRepository.findAll();
	}

	@Override
	public Itp getOne(int itpId) {
		return itpJpaRepository.getOne(itpId);
	}

	@Override
	public Itp addOne(Itp itp) {
		return itpJpaRepository.saveAndFlush(itp);
	}

	@Override
	public void delete(int itpId) {
		itpJpaRepository.deleteById(itpId);
		
	}
	

}
