package com.pmv.service;

import java.util.List;

import com.pmv.entity.HardDisk;


public interface HardDiskService {
	
	public abstract List<HardDisk> getAll();
	
	public abstract HardDisk getOne(int hardDiskId);
	
	public abstract HardDisk addOne(HardDisk hardDisk);
	
	public abstract void delete(int hardDiskId);

}
