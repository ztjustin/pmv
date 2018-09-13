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
	@Column(name="hard_disk", unique = true, nullable = false)
	private int hardDisk;
	
	@Column(name = "serial", nullable = false)
	private String serial;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="operating_system_id", nullable=false)
	private OperatingSystem operatingSystem;
	
	/*GETTERS AND SETTERS*/
	

}
