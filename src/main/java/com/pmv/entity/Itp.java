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
@Table(name="itp")
public class Itp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="itp_id", unique = true, nullable = false)
	private int itpId;
	
	@Column(name = "name_itp", nullable = false, length= 45)
	private String nameItp;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "itp")
    private PlatformDetail platformDetail;

	public Itp() {
		super();
	}
	
	/*GETTERS AND SETTERS*/
	
	
	

}
