package com.book.selling.mapper;

import java.util.List;

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

	CustomerEntity toEntity(CustomerModel customerModel);

	CustomerModel toModel(CustomerEntity customerEntity);

	default CustomerEntity builderToEntity(CustomerModelBuilder builder) {
		return toEntity(builder.build());
	}

	default CustomerModelBuilder entityToBuilder(CustomerEntity entity) {
		return new CustomerModelBuilder(toModel(entity));
	}

	List<AddressEntity> toAddressEntities(List<AddressModel> addressModels);

	List<AddressModel> toAddressModels(List<AddressEntity> addressEntities);

	List<ContactEntity> toContactEntities(List<ContactModel> contactModels);

	List<ContactModel> toContactModels(List<ContactEntity> contactEntities);
}
