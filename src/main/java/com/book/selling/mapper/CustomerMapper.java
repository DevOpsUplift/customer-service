package com.book.selling.mapper;

import org.mapstruct.Mapper;

import com.book.selling.entity.AddressEntity;
import com.book.selling.entity.ContactEntity;
import com.book.selling.entity.CustomerEntity;
import com.book.selling.model.AddressModel;
import com.book.selling.model.ContactModel;
import com.book.selling.model.CustomerModel;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	public CustomerEntity toCustomerEntity(CustomerModel customerModel);

	public AddressEntity toAddressEntity(AddressModel addressModel);

	public ContactEntity toContactEntity(ContactModel contactModel);

	public CustomerModel toCustomerModel(CustomerEntity customerEntity);

	public AddressModel toAddressModel(AddressEntity addressEntity);

	public ContactModel toContactModel(ContactEntity contactEntity);

}
