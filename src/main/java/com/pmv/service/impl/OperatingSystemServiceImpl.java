package com.pmv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.pmv.entity.OperatingSystem;
import com.pmv.repository.OperatingSystemJpaRepository;
import com.pmv.service.OperatingSystemService;

public class OperatingSystemServiceImpl implements OperatingSystemService {
	
	@Autowired
	@Qualifier("operatingSystemJpaRepository")
	private OperatingSystemJpaRepository operatingSystemJpaRepository;
	
	@Override
	public List<OperatingSystem> getAll() {
		return operatingSystemJpaRepository.findAll();
	}

	@Override
	public OperatingSystem getOne(int operatingSystemId) {
		return operatingSystemJpaRepository.getOne(operatingSystemId);
	}

	@Override
	public OperatingSystem addOne(OperatingSystem operatingSystem) {
		return operatingSystemJpaRepository.saveAndFlush(operatingSystem);
	}

	@Override
	public void delete(int operatingSystemId) {
		operatingSystemJpaRepository.deleteById(operatingSystemId);
		
	}

}
