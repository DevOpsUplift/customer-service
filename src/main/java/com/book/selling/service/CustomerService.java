package com.book.selling.service;

import java.util.UUID;

import com.book.selling.model.CustomerModel;

public interface CustomerService {

	boolean existsByEmail(String email);

	boolean existsById(UUID id);

	CustomerModel createCustomer(CustomerModel customerModel);

	CustomerModel getCustomerById(UUID id);

	CustomerModel getCustomerByEmail(String email);

	CustomerModel updateCustomer(UUID id, CustomerModel customerModel);

	void deleteCustomer(UUID id);

}
