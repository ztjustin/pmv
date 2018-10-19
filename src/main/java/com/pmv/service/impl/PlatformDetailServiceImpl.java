package com.pmv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmv.entity.PlatformDetail;
import com.pmv.repository.PlatformDetailJpaRepository;
import com.pmv.service.PlatformDetailService;

@Service("platformDetailServiceImpl")
public class PlatformDetailServiceImpl implements PlatformDetailService{
	
	@Autowired
	@Qualifier("platformDetailJpaRepository")
	private PlatformDetailJpaRepository platformDetailJpaRepository;
	
	@Override
	public List<PlatformDetail> getAll() {
		return platformDetailJpaRepository.findAll();
	}

	@Override
	public PlatformDetail getOne(int platformDetailId) {
		return platformDetailJpaRepository.getOne(platformDetailId);
	}

	@Override
	public PlatformDetail addOne(PlatformDetail platformDetail) {
		return platformDetailJpaRepository.saveAndFlush(platformDetail);
	}

	@Override
	public void delete(int platformDetailId) {
		platformDetailJpaRepository.deleteById(platformDetailId);
	}

	@Override
	public PlatformDetail getPlatformDetailByPlatformId(int platformId) {
		return platformDetailJpaRepository.findPlatformDetailByPlatformId(platformId);
	}

}
