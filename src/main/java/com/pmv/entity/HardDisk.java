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
@Table(name="hard_disk", uniqueConstraints={@UniqueConstraint(columnNames = {"serial"})})
public class HardDisk implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hard_disk_id", unique = true, nullable = false)
	private Long hardDiskId;
	
	@Column(name = "serial", nullable = false)
	private String serial;
	
	@Column(name = "hold", nullable = false)
	private Boolean hold;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="operating_system_id", nullable=false)
	private OperatingSystem operatingSystem;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="platform_detail_id", nullable=true)
	private PlatformDetail platformDetail;

	/*GETTERS AND SETTERS*/
	
	public HardDisk() {
		super();
	}
	

	public HardDisk(String serial, OperatingSystem operatingSystem, PlatformDetail platformDetail,Boolean hold) {
		super();
		this.serial = serial;
		this.operatingSystem = operatingSystem;
		this.platformDetail = platformDetail;
		this.hold = hold;
	}


	public Long getHardDiskId() {
		return hardDiskId;
	}

	public void setHardDiskId(Long hardDiskId) {
		this.hardDiskId = hardDiskId;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(OperatingSystem operatingSystem) {
		this.operatingSystem = operatingSystem;
	}


	public PlatformDetail getPlatformDetail() {
		return platformDetail;
	}


	public void setPlatformDetail(PlatformDetail platformDetail) {
		this.platformDetail = platformDetail;
	}


	public Boolean getHold() {
		return hold;
	}


	public void setHold(Boolean hold) {
		this.hold = hold;
	}
	

}
