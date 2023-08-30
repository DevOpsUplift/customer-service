package com.book.selling.serviceimpl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.book.selling.entity.CustomerEntity;
import com.book.selling.exception.CustomerNotFoundException;
import com.book.selling.mapper.CustomerMapper;
import com.book.selling.model.CustomerModel;
import com.book.selling.repository.CustomerRepository;
import com.book.selling.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	CustomerRepository customerRepository;

	CustomerMapper customerMapper;
	
	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public boolean existsByEmail(String email) {
		return customerRepository.existsByEmail(email);
	}

	@Override
	public boolean existsById(UUID id) {
		return customerRepository.existsById(id);
	}

	@Override
	public CustomerModel createCustomer(CustomerModel customerModel) {
		return customerMapper.toModel(customerRepository.save(customerMapper.toEntity(customerModel)));
	}

	@Override
	public CustomerModel getCustomerById(UUID id) {
		CustomerEntity existingEntity = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
		return customerMapper.toModel(existingEntity);
	}

	@Override
	public CustomerModel getCustomerByEmail(String email) {
		CustomerEntity existingEntity = customerRepository.findByEmail(email)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
		return customerMapper.toModel(existingEntity);
	}

	@Override
	public CustomerModel updateCustomer(UUID id, CustomerModel customerModel) {
		customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
		return customerMapper.toModel(customerRepository.save(customerMapper.toEntity(customerModel)));
	}

	@Override
	public void deleteCustomer(UUID id) {
		customerRepository.deleteById(id);
	}
}
