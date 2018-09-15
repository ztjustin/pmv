package com.pmv.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="platform")
public class Platform implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="platform_id", unique = true, nullable = false)
	private int platformId;
	
	@Column(name = "name", nullable = false, length= 45)
	private String name;
	
    @Enumerated(EnumType.STRING)
    private StatusPlatform status;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "platform")
    private PlatformDetail platformDetail;
		
	@OneToMany(mappedBy="platform")
	private List<Annotation> annotations;
	
	/*GETTERS AND SETTERS*/
	
	public Platform() {
		super();
	}

}
