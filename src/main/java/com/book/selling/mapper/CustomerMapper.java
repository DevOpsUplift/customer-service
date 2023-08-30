package com.book.selling.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import com.book.selling.builder.CustomerModelBuilder;
import com.book.selling.entity.AddressEntity;
import com.book.selling.entity.ContactEntity;
import com.book.selling.entity.CustomerEntity;
import com.book.selling.model.AddressModel;
import com.book.selling.model.ContactModel;
import com.book.selling.model.CustomerModel;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	CustomerEntity toCustomerEntity(CustomerModel customerModel);

	AddressEntity toAddressEntity(AddressModel addressModel);

	ContactEntity toContactEntity(ContactModel contactModel);

	CustomerModel toCustomerModel(CustomerEntity customerEntity);

	AddressModel toAddressModel(AddressEntity addressEntity);

	ContactModel toContactModel(ContactEntity contactEntity);

	default CustomerEntity builderToEntity(CustomerModelBuilder builder) {
		return toCustomerEntity(builder.build());
	}

	default CustomerModelBuilder entityToBuilder(CustomerEntity entity) {
		return new CustomerModelBuilder(toCustomerModel(entity));
	}
	
	default List<AddressEntity> toAddressEntities(List<AddressModel> addressModels) {
        return addressModels.stream()
                .map(this::toAddressEntity)
                .collect(Collectors.toList());
    }
	
	default List<AddressModel> toAddressModels(List<AddressEntity> addressEntities) {
        return addressEntities.stream()
                .map(this::toAddressModel)
                .collect(Collectors.toList());
    }
	
	default List<ContactEntity> toContactEntities(List<ContactModel> contactModels) {
        return contactModels.stream()
                .map(this::toContactEntity)
                .collect(Collectors.toList());
    }
	
	default List<ContactModel> toContactModels(List<ContactEntity> contactEntities) {
        return contactEntities.stream()
                .map(this::toContactModel)
                .collect(Collectors.toList());
    }	
	
}
	
