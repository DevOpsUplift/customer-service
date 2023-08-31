package com.book.selling.builder;

import java.util.UUID;

import com.book.selling.model.AddressModel;

public class AddressModelBuilder {

    private UUID addressUid;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String state;
    private Long postalCode;
    
    public AddressModelBuilder() {
    }

    public AddressModelBuilder addressUid(UUID addressUid) {
        this.addressUid = addressUid;
        return this;
    }

    public AddressModelBuilder addressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public AddressModelBuilder addressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public AddressModelBuilder addressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
        return this;
    }

    public AddressModelBuilder city(String city) {
        this.city = city;
        return this;
    }

    public AddressModelBuilder state(String state) {
        this.state = state;
        return this;
    }

    public AddressModelBuilder postalCode(Long postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public AddressModel build() {
        return new AddressModel(
            addressUid,
            addressLine1,
            addressLine2,
            addressLine3,
            city,
            state,
            postalCode
        );
    }
}
