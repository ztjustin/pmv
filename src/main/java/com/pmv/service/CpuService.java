package com.pmv.service;

import java.util.List;

import com.pmv.entity.Cpu;

public interface CpuService {
	
	public abstract  List<Cpu> getAll();
	
	public abstract Cpu getOne(Long cpuId);
	
	public abstract Cpu addOne(Cpu cpu);
	
	public abstract void delete(Long cpuId);
	
	public abstract boolean exists(Long cpuId);

}
