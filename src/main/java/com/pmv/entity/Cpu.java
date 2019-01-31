package com.pmv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cpu",uniqueConstraints={@UniqueConstraint(columnNames = {"cpu_visual_id"})})
public class Cpu implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cpu_id", unique = true, nullable = false)
	private Long cpuId;
	
	@Column(name = "cpu_name", nullable = false, length= 45)
	private String cpuName;
	
	@Column(name = "qdf", nullable = false, length= 45)
	private String qdf;
	
	@Column(name = "cpu_visual_id", nullable = false, length= 45)
	private String cpuVisualId;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="platform_detail_id", nullable = true)
	private PlatformDetail platformDetail;
	
	/*GETTERS AND SETTERS*/

	public Cpu() {
		super();
	}


	public Cpu(Long cpuId, String cpuName, String qdf, String cpuVisualId) {
		super();
		this.cpuId = cpuId;
		this.cpuName = cpuName;
		this.qdf = qdf;
		this.cpuVisualId = cpuVisualId;
	}

	public Long getCpuId() {
		return cpuId;
	}

	public void setCpuId(Long cpuId) {
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

	public PlatformDetail getPlatformDetail() {
		return platformDetail;
	}

	public void setPlatformDetail(PlatformDetail platformDetail) {
		this.platformDetail = platformDetail;
	}


	@Override
	public String toString() {
		return "Cpu [cpuId=" + cpuId + ", cpuName=" + cpuName + ", qdf=" + qdf + ", cpuVisualId=" + cpuVisualId
				+ ", platformDetail=" + platformDetail + "]";
	}
	
	
	

	
}
