package com.pmv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pch")
public class Pch implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pch_id", unique = true, nullable = false)
	private int pchId;
	
	@Column(name = "pch_name", nullable = false, length= 45)
	private String cpuName;
	
	@Column(name = "qdf", nullable = false, length= 45)
	private String qdf;
	
	@Column(name = "pch_visual_id", nullable = false, length= 45)
	private String pchVisualId;
	
	/*GETTERS AND SETTERS*/

	public Pch() {
		super();
	}

	public Pch(String cpuName, String qdf, String pchVisualId) {
		super();
		this.cpuName = cpuName;
		this.qdf = qdf;
		this.pchVisualId = pchVisualId;
	}

	public int getPchId() {
		return pchId;
	}

	public void setPchId(int pchId) {
		this.pchId = pchId;
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

	public String getPchVisualId() {
		return pchVisualId;
	}

	public void setPchVisualId(String pchVisualId) {
		this.pchVisualId = pchVisualId;
	}
	
}
