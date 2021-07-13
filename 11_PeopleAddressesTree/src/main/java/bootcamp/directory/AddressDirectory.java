package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

public class AddressDirectory {
    private final TreeMap<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList, TreeMap<Person, Address> directory) {
        //TODO convert addressList to a TreeMap assigned to directory.
        this.directory = directory;
        for (PersonAddressPair personAddressPair : addressList){
            this.directory.put(personAddressPair.getPerson(),personAddressPair.getAddress());
        }
    }

    public Optional<Address> getAddress(final Person person) {
        for (Person key : directory.keySet()) {
            if (key.equals(person)) {
                return Optional.of(directory.get(person));
            }
        }
        return Optional.empty();
    }

    public void updateAddress(final PersonAddressPair personAddress) {
        directory.put(personAddress.getPerson(), personAddress.getAddress());
    }

    public void remove(final Person person) {
        if (directory.containsKey(person)){
            directory.remove(person);
        }else{
            System.out.println("Person not found");
        }
    }

}
