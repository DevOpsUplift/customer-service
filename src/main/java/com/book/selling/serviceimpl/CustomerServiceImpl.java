package com.book.selling.serviceimpl;

import java.time.LocalTime;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.book.selling.entity.AddressEntity;
import com.book.selling.entity.ContactEntity;
import com.book.selling.entity.CustomerEntity;
import com.book.selling.exception.CustomerNotFoundException;
import com.book.selling.mapper.CustomerMapper;
import com.book.selling.model.AddressModel;
import com.book.selling.model.ContactModel;
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
		return customerMapper.toCustomerModel(customerRepository.save(toCustomerEntityBuilder(customerModel)));
	}

	@Override
	public CustomerModel getCustomerById(UUID id) {
		CustomerEntity existingEntity = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
		return toCustomerModelBuilder(existingEntity);
	}

	@Override
	public CustomerModel getCustomerByEmail(String email) {
		CustomerEntity existingEntity = customerRepository.findByEmail(email)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
		return toCustomerModelBuilder(existingEntity);
	}

	@Override
	public CustomerModel updateCustomer(UUID id, CustomerModel customerModel) {
		customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
		return toCustomerModelBuilder(customerRepository.save(toCustomerEntityBuilder(customerModel)));
	}

	@Override
	public void deleteCustomer(UUID id) {
		customerRepository.deleteById(id);
	}

	CustomerEntity toCustomerEntityBuilder(CustomerModel customerModel) {
		CustomerEntity customerEntity = customerMapper.toCustomerEntity(customerModel);
		customerEntity.setCustomerUid(UUID.randomUUID());
		customerEntity.setCustomerCode(Math.abs(UUID.randomUUID().getMostSignificantBits() % 1_000_0000));
		customerEntity.setAddressesEntities(customerModel.getAddressModels().stream()
				.map(addressModel -> toAddressEntity(addressModel, customerEntity)).collect(Collectors.toList()));
		customerEntity.setContactEntities(customerModel.getContactModels().stream()
				.map(contactModel -> toContactEntity(contactModel, customerEntity)).collect(Collectors.toList()));
		customerEntity.setLastLogin(LocalTime.now());
		return customerEntity;
	}

	AddressEntity toAddressEntity(AddressModel addressModel, CustomerEntity customerEntity) {
		AddressEntity addressEntity = customerMapper.toAddressEntity(addressModel);
		addressEntity.setAddressUid(UUID.randomUUID());
		addressEntity.setCustomerEntity(customerEntity);
		return addressEntity;
	}

	ContactEntity toContactEntity(ContactModel contactModel, CustomerEntity customerEntity) {
		ContactEntity contactEntity = customerMapper.toContactEntity(contactModel);
		contactEntity.setContactUid(UUID.randomUUID());
		contactEntity.setCustomerEntity(customerEntity);
		return contactEntity;
	}

	CustomerModel toCustomerModelBuilder(CustomerEntity customerEntity) {
		CustomerModel customerModel = customerMapper.toCustomerModel(customerEntity);
		customerModel.setAddressModels(customerMapper.toAddressModels(customerEntity.getAddressesEntities()));
		customerModel.setContactModels(customerMapper.toContactModels(customerEntity.getContactEntities()));
		return customerModel;
	}
}
