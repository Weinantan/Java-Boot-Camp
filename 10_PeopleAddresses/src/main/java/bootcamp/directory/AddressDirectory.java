package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AddressDirectory {
    private final Map<Person, Address> directory;


    public AddressDirectory(final List<PersonAddressPair> addressList) {
        this.directory = new HashMap<>();
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

    @Override
    public String toString() {
        return "AddressDirectory{" +
                "directory=" + directory +
                '}';
    }
}
