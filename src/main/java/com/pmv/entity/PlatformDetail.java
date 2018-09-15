package com.pmv.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="platform_detail")
public class PlatformDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="platform_detail_id", unique = true, nullable = false)
	private int platformDetailId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="hard_disk_id", nullable=false)
	private HardDisk hardDisk;
	
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "platform_id", nullable = false)
    private Platform platform;
    
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "itp_id", nullable = false)
    private Itp itp;
    
    @Enumerated(EnumType.STRING)
    private Project project;
    
	@Column(name = "last_update", nullable = false)
	private LocalDate lastUpdate;
	
	/*GETTERS AND SETTERS*/
    
	public PlatformDetail() {
		super();
	}


}
