package com.pmv.service;

import java.util.List;

import com.pmv.entity.PlatformDetail;

public interface PlatformDetailService {
	
	public abstract List<PlatformDetail> getAll();
	
	public abstract PlatformDetail getOne(int platformDetailId);
	
	public abstract PlatformDetail addOne(PlatformDetail platformDetail);
	
	public abstract void delete(int platformDetailId);

}
