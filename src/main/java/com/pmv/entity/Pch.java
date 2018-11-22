package com.pmv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	private String pchName;
	
	@Column(name = "qdf", nullable = false, length= 45)
	private String qdf;
	
	@Column(name = "pch_visual_id", nullable = false, length= 45)
	private String pchVisualId;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "pch")
    private PlatformDetail platformDetail;
	
	/*GETTERS AND SETTERS*/

	public Pch() {
		super();
	}
	
	public Pch(int pchId, String pchName, String qdf, String pchVisualId) {
		super();
		this.pchId = pchId;
		this.pchName = pchName;
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
		return pchName;
	}

	public void setCpuName(String cpuName) {
		this.pchName = cpuName;
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

	public PlatformDetail getPlatformDetail() {
		return platformDetail;
	}

	public void setPlatformDetail(PlatformDetail platformDetail) {
		this.platformDetail = platformDetail;
	}

	public String getPchName() {
		return pchName;
	}

	public void setPchName(String pchName) {
		this.pchName = pchName;
	}
	
	
}
