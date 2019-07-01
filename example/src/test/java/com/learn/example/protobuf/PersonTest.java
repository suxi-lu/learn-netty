package com.learn.example.protobuf;

import org.junit.Test;

public class PersonTest {

    @Test
    public void personCreateTest() throws Exception {
        AddressBookProto.Person john =
                AddressBookProto.Person.newBuilder()
                        .setId(1234)
                        .setName("John Doe")
                        .setEmail("jdoe@example.com")
                        .addPhones(
                                AddressBookProto.Person.PhoneNumber.newBuilder()
                                        .setNumber("555-4321")
                                        .setType(AddressBookProto.Person.PhoneType.HOME))
                        .build();

        byte[] bytes = john.toByteArray();

        AddressBookProto.Person result = AddressBookProto.Person.parseFrom(bytes);

        System.out.println(result.getId());
        System.out.println(result.getName());
        System.out.println(result.getEmail());
        System.out.println(result.getPhones(0).getNumber());

    }

}
