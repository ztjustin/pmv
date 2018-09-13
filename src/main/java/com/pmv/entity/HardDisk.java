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

@Entity
@Table(name="hard_disk")
public class HardDisk implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hard_disk_id", unique = true, nullable = false)
	private int hardDiskId;
	
	@Column(name = "serial", nullable = false)
	private String serial;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="operating_system_id", nullable=false)
	private OperatingSystem operatingSystem;

	/*GETTERS AND SETTERS*/
	
	public HardDisk() {
		super();
	}

	public HardDisk(String serial, OperatingSystem operatingSystem) {
		super();
		this.serial = serial;
		this.operatingSystem = operatingSystem;
	}

	public int getHardDiskId() {
		return hardDiskId;
	}

	public void setHardDiskId(int hardDiskId) {
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

}
