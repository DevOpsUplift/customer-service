package com.book.selling.mapper;

import java.time.LocalTime;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.selling.entity.AddressEntity;
import com.book.selling.entity.ContactEntity;
import com.book.selling.entity.CustomerEntity;
import com.book.selling.model.AddressModel;
import com.book.selling.model.ContactModel;
import com.book.selling.model.CustomerModel;

@Service
public class CustomerUtilMapper {

	@Autowired
	private CustomerMapper customerMapper;

	public CustomerEntity toCustomerEntityBuilder(CustomerModel customerModel) {
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

	public AddressEntity toAddressEntity(AddressModel addressModel, CustomerEntity customerEntity) {
		AddressEntity addressEntity = customerMapper.toAddressEntity(addressModel);
		addressEntity.setAddressUid(UUID.randomUUID());
		addressEntity.setCustomerEntity(customerEntity);
		return addressEntity;
	}

	public ContactEntity toContactEntity(ContactModel contactModel, CustomerEntity customerEntity) {
		ContactEntity contactEntity = customerMapper.toContactEntity(contactModel);
		contactEntity.setContactUid(UUID.randomUUID());
		contactEntity.setCustomerEntity(customerEntity);
		return contactEntity;
	}

	public CustomerModel toCustomerModelBuilder(CustomerEntity customerEntity) {
		CustomerModel customerModel = customerMapper.toCustomerModel(customerEntity);
		customerModel.setAddressModels(customerEntity.getAddressesEntities().stream()
				.map(addressEntity -> toAddressModel(addressEntity)).collect(Collectors.toList()));
		customerModel.setContactModels(customerEntity.getContactEntities().stream()
				.map(contactEntity -> toContactMpdel(contactEntity)).collect(Collectors.toList()));
		return customerModel;
	}

	public AddressModel toAddressModel(AddressEntity addressEntity) {
		AddressModel addressModel = customerMapper.toAddressModel(addressEntity);
		return addressModel;
	}

	public ContactModel toContactMpdel(ContactEntity contactEntity) {
		ContactModel contactModel = customerMapper.toContactModel(contactEntity);
		return contactModel;
	}

}
