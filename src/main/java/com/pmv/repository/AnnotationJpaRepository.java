package com.pmv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmv.entity.Annotation;

@Repository("annotationJpaRepository")
public interface AnnotationJpaRepository extends JpaRepository<Annotation, Serializable> {
	

}
