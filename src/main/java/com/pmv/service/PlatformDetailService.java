package com.pmv.service;

import java.util.List;

import com.pmv.entity.PlatformDetail;

public interface PlatformDetailService {
	
	public abstract List<PlatformDetail> getAll();
	
	public abstract PlatformDetail getOne(Long long1);
	
	public abstract PlatformDetail addOne(PlatformDetail platformDetail);
	
	public abstract void delete(Long platformDetailId);

	public abstract PlatformDetail getPlatformDetailByPlatformId(Long platformId);


}
