package com.pmv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Pch implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pch_id", unique = true, nullable = false)
	private int pchId;
	
	@Column(name = "pch-name", nullable = false, length= 45)
	private String cpuName;
	
	@Column(name = "qdf", nullable = false, length= 45)
	private String qdf;
	
	@Column(name = "pch_visual_id", nullable = false, length= 45)
	private String pchVisualId;
	
	/*GETTERS AND SETTERS*/

	public Pch() {
		super();
	}
	
	
	
	

}
