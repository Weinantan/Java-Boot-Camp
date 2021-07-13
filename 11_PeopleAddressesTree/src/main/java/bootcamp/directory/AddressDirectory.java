package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

public class AddressDirectory {
    private final TreeMap<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        //TODO convert addressList to a TreeMap assigned to directory.
        this.directory = new TreeMap<>();
        for (PersonAddressPair personAddressPair : addressList){
            this.directory.put(personAddressPair.getPerson(),personAddressPair.getAddress());
        }
    }

    public Optional<Address> getAddress(final Person person) {
        return Optional.ofNullable(directory.get(person));
    }

    public void updateAddress(final PersonAddressPair personAddress) {
        directory.replace(personAddress.getPerson(), personAddress.getAddress());
    }

    public void remove(final Person person) {
        directory.remove(person);
    }

}
