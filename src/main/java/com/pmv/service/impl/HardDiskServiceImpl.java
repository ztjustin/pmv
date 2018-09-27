package com.pmv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.pmv.entity.HardDisk;
import com.pmv.repository.HardDiskJpaRepository;
import com.pmv.service.HardDiskService;

public class HardDiskServiceImpl implements HardDiskService {
	
	
	@Autowired
	@Qualifier("hardDiskJpaRepository")
	private HardDiskJpaRepository hardDiskJpaRepository;

	@Override
	public List<HardDisk> getAll() {
		return hardDiskJpaRepository.findAll();
	}

	@Override
	public HardDisk getOne(int hardDiskId) {
		return hardDiskJpaRepository.getOne(hardDiskId);
	}

	@Override
	public HardDisk addOne(HardDisk hardDisk) {
		return hardDiskJpaRepository.saveAndFlush(hardDisk);
	}

	@Override
	public void delete(int hardDiskId) {
		hardDiskJpaRepository.deleteById(hardDiskId);
		
	}

}