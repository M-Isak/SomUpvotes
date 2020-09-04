package com.somupvotes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.somupvotes.domain.Product;
import com.somupvotes.domain.User;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
	
  @Query(" select p from Product p "
		  + " join fetch p.user "
		  + " where p.id = :id ")
    Optional<Product>	 findByIdWithUser(Long id);
	// select * from product where user = :user;
	List<Product> findByUser(User user);
	
	// this will roughly create this SQL statement: select * from product where name = :name; 
	Optional<Product> findByName(String name);

}
