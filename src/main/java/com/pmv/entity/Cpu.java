package com.pmv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class Cpu implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cpu_id", unique = true, nullable = false)
	private int cpuId;
	
	@Column(name = "cpu-name", nullable = false, length= 45)
	private String cpuName;
	
	@Column(name = "qdf", nullable = false, length= 45)
	private String qdf;
	
	@Column(name = "cpu_visual_id", nullable = false, length= 45)
	private String cpuVisualId;

	public Cpu() {
		super();
	}
	
	/*GETTERS AND SETTERS*/
	
	
}
