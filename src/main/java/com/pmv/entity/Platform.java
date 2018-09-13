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
		
	@OneToMany(mappedBy="annotation")
	private List<Annotation> annotations;
	
	/*GETTERS AND SETTERS*/
	
	public Platform() {
		super();
	}

	public Platform(String name, StatusPlatform status, PlatformDetail platformDetail, List<Annotation> annotations) {
		super();
		this.name = name;
		this.status = status;
		this.platformDetail = platformDetail;
		this.annotations = annotations;
	}

	public int getPlatformId() {
		return platformId;
	}

	public void setPlatformId(int platformId) {
		this.platformId = platformId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StatusPlatform getStatus() {
		return status;
	}

	public void setStatus(StatusPlatform status) {
		this.status = status;
	}

	public PlatformDetail getPlatformDetail() {
		return platformDetail;
	}

	public void setPlatformDetail(PlatformDetail platformDetail) {
		this.platformDetail = platformDetail;
	}

	public List<Annotation> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(List<Annotation> annotations) {
		this.annotations = annotations;
	}

}
