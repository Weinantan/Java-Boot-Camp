package main.java.bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;

import java.util.*;

public class AddressDirectory {
    private final Map<Person, Address> peopleDirectory;
    private final Map<Address, List<Person>> addressDirectory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        addressDirectory = new TreeMap<>();
        peopleDirectory = new TreeMap<>();

        for (PersonAddressPair personAddressPair : addressList) {
            this.peopleDirectory.put(personAddressPair.getPerson(), personAddressPair.getAddress());
        }


        for (PersonAddressPair personAddressPair : addressList) {
            if (addressDirectory.containsKey(personAddressPair.getAddress())) {
                List<Person> personList = addressDirectory.get(personAddressPair.getAddress());
                personList.add(personAddressPair.getPerson());
            } else {
                List<Person> list = new ArrayList<>();
                list.add(personAddressPair.getPerson());
                addressDirectory.put(personAddressPair.getAddress(), list);
            }
        }

        //TODO convert addressList to a TreeMap assigned to directory.
    }


    public Optional<Address> getAddress(final Person person) {
        return Optional.ofNullable(peopleDirectory.get(person));
    }


    public Status updateAddress(Address oldAddress, Address newAddress) {
        if (!addressDirectory.containsKey(oldAddress)) {
            return Status.FAILED_NO_KEY_FOUND;
        }

        List<Person> allThePeopleToBeUpdated = addressDirectory.get(oldAddress);
        //This give you a list of persons that have the same address.
        for (Person person : allThePeopleToBeUpdated) {
            updateAddress(new PersonAddressPair(person, newAddress));
        }

        //sort out the address dir update the new address and get rid of the old address.
        addressDirectory.put(newAddress,addressDirectory.get(oldAddress));
        addressDirectory.remove(oldAddress);
        return Status.SUCCESS;


    }

    public void updateAddress(final PersonAddressPair personAddress) {
        //changing people in the people dir
     if (!peopleDirectory.containsKey(personAddress.getPerson())){
         peopleDirectory.put(personAddress.getPerson(),personAddress.getAddress());
     }else{
         peopleDirectory.replace(personAddress.getPerson(),personAddress.getAddress());
     }

     // changing the address in the address dir
        if (addressDirectory.containsKey(personAddress.getAddress())){
            List<Person> list = addressDirectory.get(personAddress.getAddress());
            list.add(personAddress.getPerson());
        }else {
            List<Person> list = new ArrayList<>();
            list.add(personAddress.getPerson());
            addressDirectory.put(personAddress.getAddress(), list);
        }

    }


    public List<Person> getPersonAtAddress(final Address address){
        return addressDirectory.get(address)!= null ? addressDirectory.get(address) : new ArrayList<>();
    }


    public Status remove(final Address address) {
        //check to see weather the address directory has the address we are passing in.
        if (!addressDirectory.containsKey(address)) {
            return Status.FAILED_NO_KEY_FOUND;
        }

        //loop through address directory, remove the persons that have that address we are passing in.

        for (Person person : addressDirectory.get(address)) {
            peopleDirectory.remove(person);
        }
        //remove the address from the address directory.

        addressDirectory.remove(address);
        return Status.SUCCESS;
    }

    public Status remove(final Person person){
        //check the people dir if its there remove else key not found
        if (!peopleDirectory.containsKey(person)){
            return Status.FAILED_NO_KEY_FOUND;
        }
        peopleDirectory.remove(person);

        //now to do it for address dir
        addressDirectory.forEach((a,p) -> p.removeIf(person::equals));
        return Status.SUCCESS;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDirectory that = (AddressDirectory) o;
        return Objects.equals(peopleDirectory, that.peopleDirectory) && Objects.equals(addressDirectory, that.addressDirectory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peopleDirectory, addressDirectory);
    }

}
