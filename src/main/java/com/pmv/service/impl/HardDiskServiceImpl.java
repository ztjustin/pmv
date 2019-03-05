package com.pmv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmv.entity.HardDisk;
import com.pmv.repository.HardDiskJpaRepository;
import com.pmv.service.HardDiskService;

@Service("hardDiskServiceImpl")
public class HardDiskServiceImpl implements HardDiskService {
	
	@Autowired
	@Qualifier("hardDiskJpaRepository")
	private HardDiskJpaRepository hardDiskJpaRepository;

	@Override
	public List<HardDisk> getAll() {
		return hardDiskJpaRepository.findAll();
	}

	@Override
	public HardDisk getOne(Long hardDiskId) {
		return hardDiskJpaRepository.getOne(hardDiskId);
	}

	@Override
	public HardDisk addOne(HardDisk hardDisk) {
		return hardDiskJpaRepository.saveAndFlush(hardDisk);
	}

	@Override
	public void delete(Long hardDiskId) {
		hardDiskJpaRepository.deleteById(hardDiskId);
		
	}

	@Override
	public boolean exists(Long hardDiskId) {
		return hardDiskJpaRepository.existsById(hardDiskId);
	}

	@Override
	public List<HardDisk> getHardDisksByNullPlatform() {
		return hardDiskJpaRepository.findHardDiskWithNonePlatform();
	}

	@Override
	public void updateOnHoldFalse(Long detailPlatformId) {
		 hardDiskJpaRepository.updateHoldStatusFalse(detailPlatformId);
	}

}
