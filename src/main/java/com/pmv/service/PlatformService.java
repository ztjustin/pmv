package com.pmv.service;

import java.util.List;

import com.pmv.entity.Platform;

public interface PlatformService {
	
	public abstract List<Platform> getAll();
	
	public abstract Platform getOne(int platformId);
	
	public abstract Platform addOne(Platform platform);
	
	public abstract void delete(int platformId);

}
