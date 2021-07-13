package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AddressDirectory {
    private final Map<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList, Map<Person, Address> directory) {
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

    @Override
    public String toString() {
        return "AddressDirectory{" +
                "directory=" + directory +
                '}';
    }
}
