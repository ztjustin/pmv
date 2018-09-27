package com.pmv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.pmv.entity.Cpu;
import com.pmv.repository.CpuJpaRepository;
import com.pmv.service.CpuService;

public class CpuServiceImpl implements CpuService {
	
	@Autowired
	@Qualifier("cpuJpaRepository")
	private CpuJpaRepository cpuJpaRepository;
	

	@Override
	public List<Cpu> getAll() {
		return cpuJpaRepository.findAll();
	}

	@Override
	public Cpu getOne(int cpuId) {
		return cpuJpaRepository.getOne(cpuId);
	}

	@Override
	public Cpu addOne(Cpu cpu) {
		return cpuJpaRepository.saveAndFlush(cpu);
	}

	@Override
	public void delete(int cpuId) {
		cpuJpaRepository.deleteById(cpuId);
		
	}

}
