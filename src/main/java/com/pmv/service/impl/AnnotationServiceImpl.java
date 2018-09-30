package com.pmv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmv.entity.Annotation;
import com.pmv.repository.AnnotationJpaRepository;
import com.pmv.service.AnnotationService;

@Service("annotationServiceImpl")
public class AnnotationServiceImpl implements AnnotationService {
	
	@Autowired
	@Qualifier("annotationJpaRepository")
	private AnnotationJpaRepository annotationJpaRepository;

	@Override
	public List<Annotation> getAll() {
		return annotationJpaRepository.findAll();
	}

	@Override
	public Annotation getOne(int annotationID) {
		return annotationJpaRepository.getOne(annotationID);
	}

	@Override
	public Annotation addOne(Annotation annotation) {
		return annotationJpaRepository.saveAndFlush(annotation);
	}

	@Override
	public void delete(int annotationID) {
		annotationJpaRepository.deleteById(annotationID);
		
	}
	
	

}
