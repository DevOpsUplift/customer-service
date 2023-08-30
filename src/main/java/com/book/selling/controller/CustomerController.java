package com.book.selling.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.selling.model.CustomerModel;
import com.book.selling.model.LoginModel;
import com.book.selling.serviceimpl.CustomerServiceImpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/customers/v1")
public class CustomerController {

	private CustomerServiceImpl customerService;

	public CustomerController(CustomerServiceImpl customerService) {
		this.customerService = customerService;
	}

	@PostMapping("/createCustomer")
	public ResponseEntity<CustomerModel> createCustomer(@Valid @RequestBody CustomerModel customerModel) {
		if (customerService.existsByEmail(customerModel.getEmail())) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerModel));
	}

	@GetMapping("/getCustomerById{id}")
	public ResponseEntity<CustomerModel> getCustomer(@PathVariable UUID id) {
		CustomerModel customerModel = customerService.getCustomerById(id);
		if (customerModel == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customerModel);
	}

	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<CustomerModel> updateCustomer(@PathVariable UUID id,
			@Valid @RequestBody CustomerModel customerModel) {
		if (!customerService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		CustomerModel updatedCustomer = customerService.updateCustomer(id, customerModel);
		return ResponseEntity.ok(updatedCustomer);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable UUID id) {
		if (!customerService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		customerService.deleteCustomer(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginModel loginModel) {
		if (!customerService.existsByEmail(loginModel.getEmail())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email not registered");
		}

		Optional<CustomerModel> customerModelOptional = Optional
				.ofNullable(customerService.getCustomerByEmail(loginModel.getEmail()));
		if (customerModelOptional.isEmpty()
				|| !customerModelOptional.get().getPassword().equals(loginModel.getPassword())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
		}
		if (!"ACTIVE".equals(customerModelOptional.get().getStatus())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Customer is not active");
		}

		customerService.updateCustomer(customerModelOptional.get().getCustomerUid(), customerModelOptional.get());
		return ResponseEntity.ok("Login successful");
	}
}
