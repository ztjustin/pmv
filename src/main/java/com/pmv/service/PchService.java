package com.pmv.service;

import java.util.List;

import com.pmv.entity.Pch;

public interface PchService {
	
	public abstract List<Pch> getAll();
	
	public abstract Pch getOne(Long pchId);
	
	public abstract Pch addOne(Pch pch);
	
	public abstract void delete(Long pchId);
	
	public abstract boolean exists(Long pchId);
	
	

}
