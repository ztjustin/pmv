package com.pmv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmv.entity.Cpu;
import com.pmv.repository.CpuJpaRepository;
import com.pmv.service.CpuService;

@Service("cpuServiceImpl")
public class CpuServiceImpl implements CpuService {
	
	@Autowired
	@Qualifier("cpuJpaRepository")
	private CpuJpaRepository cpuJpaRepository;
	

	@Override
	public List<Cpu> getAll() {
		return cpuJpaRepository.findAll();
	}

	@Override
	public Cpu getOne(Long cpuId) {
		return cpuJpaRepository.getOne(cpuId);
	}

	@Override
	public Cpu addOne(Cpu cpu) {
		return cpuJpaRepository.save(cpu);
	}

	@Override
	public void delete(Long cpuId) {
		cpuJpaRepository.deleteById(cpuId);
		
	}

	@Override
	public boolean exists(Long cpuId) {
		return cpuJpaRepository.existsById(cpuId);
	}


}
