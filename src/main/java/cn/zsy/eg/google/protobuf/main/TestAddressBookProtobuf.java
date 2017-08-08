package cn.zsy.eg.google.protobuf.main;

import cn.zsy.eg.google.protobuf.bean.AddressBookProtos;
import com.google.protobuf.InvalidProtocolBufferException;

public class TestAddressBookProtobuf {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
            .setId(1234)
            .setName("John Doe")
            .setEmail("jdoe@example.com")
            .addPhones(AddressBookProtos.Person.PhoneNumber.newBuilder()
                .setNumber("555-4321")
                .setType(AddressBookProtos.Person.PhoneType.HOME)).build();
        AddressBookProtos.AddressBook addressBookProtos = AddressBookProtos.AddressBook.newBuilder()
            .addPeople(person).build();
        byte[] bytes = addressBookProtos.toByteArray();
        AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook.parseFrom(bytes);
        System.out.println(addressBook.toString());
        System.out.println("=========for==================");
        for (AddressBookProtos.Person person1 : addressBook.getPeopleList()) {
            System.out.println(person1.toString());
            System.out.println("Person ID: " + person.getId());
            System.out.println("  Name: " + person.getName());
            if (person.hasEmail()) {
                System.out.println("  E-mail address: " + person.getEmail());
            }
            for (AddressBookProtos.Person.PhoneNumber phoneNumber : person1.getPhonesList()) {
                switch (phoneNumber.getType()) {
                    case MOBILE:
                        System.out.print("  Mobile phone #: ");
                        break;
                    case HOME:
                        System.out.print("  Home phone #: ");
                        break;
                    case WORK:
                        System.out.print("  Work phone #: ");
                        break;
                }
                System.out.println(phoneNumber.getNumber());
            }
            System.out.println("-----------------------");
        }

    }

}
