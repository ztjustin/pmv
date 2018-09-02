package com.pmv.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="platform")
public class Platform implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="platform_id", unique = true, nullable = false)
	private int platformId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="status_id", nullable=false)
	private Status statusId;
	
	
	@OneToMany(mappedBy="annotation")
	private List<Annotation> annotations;
	
	@Column(name = "name", nullable = false, length= 45)
	private String name;
	
	

}
