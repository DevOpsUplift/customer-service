package com.book.selling.builder;

import java.util.UUID;

import com.book.selling.model.ContactModel;

public class ContactModelBuilder {

    private UUID contactUid;
    private String contactType;
    private String number;

    public ContactModelBuilder() {
    }

    public ContactModelBuilder contactUid(UUID contactUid) {
        this.contactUid = contactUid;
        return this;
    }

    public ContactModelBuilder contactType(String contactType) {
        this.contactType = contactType;
        return this;
    }

    public ContactModelBuilder number(String number) {
        this.number = number;
        return this;
    }

    public ContactModel build() {
        return new ContactModel(
            contactUid,
            contactType,
            number            
        );
    }
}
