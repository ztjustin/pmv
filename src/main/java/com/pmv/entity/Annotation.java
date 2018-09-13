package com.pmv.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name="annotation")
public class Annotation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="annotation_id", unique = true, nullable = false)
	private int annotationId;
	
	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	@Column(name = "time", nullable = false)
	private LocalTime time;
	
	@Column(name = "description", nullable = false, length= 45)
	private String description;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="platform_id", nullable=false)
	private Platform platform;
	
	/*GETTERS AND SETTERS*/
	
	public Annotation() {
		super();
	}

	public Annotation(LocalDate date, LocalTime time, String description, Platform platform) {
		super();
		this.date = date;
		this.time = time;
		this.description = description;
		this.platform = platform;
	}

	public int getAnnotationId() {
		return annotationId;
	}

	public void setAnnotationId(int annotationId) {
		this.annotationId = annotationId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

}
