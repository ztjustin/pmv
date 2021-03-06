package com.pmv.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmv.entity.HardDisk;


@Repository("hardDiskJpaRepository")
@Transactional
public interface HardDiskJpaRepository extends JpaRepository<HardDisk, Serializable> {
	
	@Query(value = "from HardDisk where platform_detail_id is NULL")
    public abstract List<HardDisk> findHardDiskWithNonePlatform();
	
	@Transactional
	@Modifying
	@Query(value = "update HardDisk set hold=false where platform_detail_id=:detailPlatformId")
	public abstract void updateHoldStatusFalse(@Param("detailPlatformId") Long detailPlatformId);
	
}
