package com.pmv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class PlatformDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="platform_detail_id", unique = true, nullable = false)
	private int platformDetailId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="hard_disk_id", nullable=false)
	private HardDisk hardDisk;
	
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "platform_id", nullable = false)
    private Platform platform;
	
	/*GETTERS AND SETTERS*/
    
	public PlatformDetail() {
		super();
	}

	public PlatformDetail(HardDisk hardDisk, Platform platform) {
		super();
		this.hardDisk = hardDisk;
		this.platform = platform;
	}

	public int getPlatformDetailId() {
		return platformDetailId;
	}

	public void setPlatformDetailId(int platformDetailId) {
		this.platformDetailId = platformDetailId;
	}

	public HardDisk getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(HardDisk hardDisk) {
		this.hardDisk = hardDisk;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
}
