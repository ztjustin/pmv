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
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="platform_id", nullable=false)
	private Platform platform;
	
	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	@Column(name = "time", nullable = false)
	private LocalTime time;
	
	@Column(name = "description", nullable = false, length= 45)
	private String description;
	
	

}
