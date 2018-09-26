package com.pmv.service;

import java.util.List;

import com.pmv.entity.Itp;

public interface ItpService {
	
	public abstract List<Itp> getAll();
	
	public abstract Itp getOne(int itpId);
	
	public abstract Itp addOne(Itp itp);
	
	public abstract void delete(int itpId);

}
