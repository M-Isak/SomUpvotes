package com.somupvotes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somupvotes.domain.Feature;
import com.somupvotes.domain.Product;
import com.somupvotes.domain.User;
import com.somupvotes.repository.FeatureRepo;
import com.somupvotes.repository.ProductRepo;

@Service
public class FeatureService {
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private FeatureRepo featureRepo;
	public Feature createFeature(Long productId, User user) {
		
		Feature feature = new Feature();
				
		 Optional<Product> productOpt= productRepo.findById(productId);
	
		if(productOpt.isPresent()) {
			Product product = productOpt.get();
			
	    	feature.setProduct(product);	
	    	product.getFeatures().add(feature);
	    	
	    	feature.setUser(user);
	    	user.getFeatures().add(feature);
	    	
	    	feature.setStatus("Pending review");
	    	
	    	return featureRepo.save(feature);
		}
	
	return feature;

	}
	public Feature save(Feature feature) {
		// TODO Auto-generated method stub
		return featureRepo.save(feature);
	}
	public Optional<Feature> findById(Long featureId) {
		// TODO Auto-generated method stub
		return featureRepo.findById(featureId);
		
	}
}
