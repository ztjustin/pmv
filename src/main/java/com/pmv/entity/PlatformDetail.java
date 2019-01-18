package com.pmv.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="platform_detail")
public class PlatformDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="platform_detail_id", unique = true, nullable = false)
	private Long platformDetailId;
	
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "platform_id", nullable = false)
    private Platform platform;
    
	@OneToMany(mappedBy="platformDetail")
	private List<HardDisk> hardDisks;
    
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "itp_id", nullable = false)
    private Itp itp;
    
    @Enumerated(EnumType.STRING)
    private Project project;
    
	@Column(name = "last_update", nullable = false)
	private LocalDate lastUpdate;
	
	@OneToMany(mappedBy="platformDetail")
	private List<Cpu> cpus;
    
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pch_id", nullable = false)
    private Pch pch;
    
	
	/*GETTERS AND SETTERS*/
    
	public PlatformDetail() {
		super();
	}

	public PlatformDetail(List<HardDisk> hardDisks, Platform platform, Itp itp, Project project, LocalDate lastUpdate) {
		super();
		this.hardDisks = hardDisks;
		this.platform = platform;
		this.itp = itp;
		this.project = project;
		this.lastUpdate = lastUpdate;
	}

	public Long getPlatformDetailId() {
		return platformDetailId;
	}

	public void setPlatformDetailId(Long platformDetailId) {
		this.platformDetailId = platformDetailId;
	}
	
	public List<HardDisk> getHardDisks() {
		return hardDisks;
	}

	public void setHardDisks(List<HardDisk> hardDisks) {
		this.hardDisks = hardDisks;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public Itp getItp() {
		return itp;
	}

	public void setItp(Itp itp) {
		this.itp = itp;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public LocalDate getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<Cpu> getCpus() {
		return cpus;
	}

	public void setCpus(List<Cpu> cpus) {
		this.cpus = cpus;
	}

	public Pch getPch() {
		return pch;
	}

	public void setPch(Pch pch) {
		this.pch = pch;
	}
	
		
}
