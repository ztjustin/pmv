package com.pmv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmv.entity.Platform;
import com.pmv.repository.PlatformJpaRepository;
import com.pmv.service.PlatformService;

@Service("platformServiceImpl")
public class PlatformServiceImpl implements PlatformService{
	
	@Autowired
	@Qualifier("platformJpaRepository")
	private PlatformJpaRepository platformJpaRepository;

	@Override
	public List<Platform> getAll() {
		return platformJpaRepository.findAll();
	}

	@Override
	public Platform getOne(Long platformId) {
		return platformJpaRepository.getOne(platformId);
	}

	@Override
	public Platform addOne(Platform platform) {
		return platformJpaRepository.save(platform);
	}

	@Override
	public void delete(Long platformId) {
		platformJpaRepository.deleteById(platformId);
		
	}

	@Override
	public boolean exists(Long platformId) {
		return platformJpaRepository.existsById(platformId);
	}

	
}
