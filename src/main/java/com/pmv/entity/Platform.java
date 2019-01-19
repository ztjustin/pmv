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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="platform", uniqueConstraints={@UniqueConstraint(columnNames = {"station"})})
public class Platform implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="platform_id", unique = true, nullable = false)
	private Long platformId;
	
	@Column(name = "name", nullable = false, length= 45)
	private String name;
	
	@Column(name = "station", nullable = false, length= 45)
	private String station;
	
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length= 45)
    private StatusPlatform status;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "department", nullable = false, length= 45)
    private Department department;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "platform", optional = true)
    private PlatformDetail platformDetail;
		
	@OneToMany(mappedBy="platform")
	private List<Annotation> annotations;
	
	/*GETTERS AND SETTERS*/
	
	public Platform() {
		super();
	}
	

	public Platform(String name, String station, StatusPlatform status, Department department) {
		super();
		this.name = name;
		this.station = station;
		this.status = status;
		this.department = department;
	}


	public Long getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Long platformId) {
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}


	@Override
	public String toString() {
		return "Platform [platformId=" + platformId + ", name=" + name + ", station=" + station + ", status=" + status
				+ ", department=" + department + ", platformDetail=" + platformDetail + ", annotations=" + annotations
				+ "]";
	}
	
	
}
