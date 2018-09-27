package com.pmv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cpu")
public class Cpu implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cpu_id", unique = true, nullable = false)
	private int cpuId;
	
	@Column(name = "cpu_name", nullable = false, length= 45)
	private String cpuName;
	
	@Column(name = "qdf", nullable = false, length= 45)
	private String qdf;
	
	@Column(name = "cpu_visual_id", nullable = false, length= 45)
	private String cpuVisualId;
	
	/*GETTERS AND SETTERS*/

	public Cpu() {
		super();
	}

	public Cpu(int cpuId, String cpuName, String qdf, String cpuVisualId) {
		super();
		this.cpuId = cpuId;
		this.cpuName = cpuName;
		this.qdf = qdf;
		this.cpuVisualId = cpuVisualId;
	}

	public int getCpuId() {
		return cpuId;
	}

	public void setCpuId(int cpuId) {
		this.cpuId = cpuId;
	}

	public String getCpuName() {
		return cpuName;
	}

	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}

	public String getQdf() {
		return qdf;
	}

	public void setQdf(String qdf) {
		this.qdf = qdf;
	}

	public String getCpuVisualId() {
		return cpuVisualId;
	}

	public void setCpuVisualId(String cpuVisualId) {
		this.cpuVisualId = cpuVisualId;
	}
	
	
}
