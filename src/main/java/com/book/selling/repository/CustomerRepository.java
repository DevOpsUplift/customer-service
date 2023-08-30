package com.book.selling.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.selling.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
	
	boolean existsByEmail(String email);
	
	 Optional<CustomerEntity> findByEmail(String email);

}
