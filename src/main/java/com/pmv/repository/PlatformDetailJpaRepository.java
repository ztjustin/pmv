package com.pmv.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pmv.entity.PlatformDetail;

@Repository("platformDetailJpaRepository")
public interface PlatformDetailJpaRepository extends JpaRepository<PlatformDetail, Serializable> {
	
	@Query(value = "from PlatformDetail where platform_id = :platformId")
    public abstract PlatformDetail findPlatformDetailByPlatformId(@Param("platformId")Long platformId);
	
}
