package com.pmv.service;

import java.util.List;

import com.pmv.entity.HardDisk;


public interface HardDiskService {
	
	public abstract List<HardDisk> getAll();
	
	public abstract HardDisk getOne(Long hardDiskId);
	
	public abstract HardDisk addOne(HardDisk hardDisk);
	
	public abstract void delete(Long hardDiskId);

	public abstract boolean exists(Long hardDiskId);
	
	public abstract List<HardDisk> getHardDisksByNullPlatform();
	
	public abstract void updateOnHoldFalse(Long detailPlatformId);
	
	

}
