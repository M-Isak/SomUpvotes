package com.somupvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.somupvotes.domain.Feature;

@Repository
public interface FeatureRepo  extends JpaRepository<Feature, Long>{
	

}
