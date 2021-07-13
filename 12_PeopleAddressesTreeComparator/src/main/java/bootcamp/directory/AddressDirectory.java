package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.*;

public class AddressDirectory {
    private final Map<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        directory = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                int compareNames = person1.getFirstName().compareToIgnoreCase(person2.getFirstName());
                if (compareNames == 0){
                    compareNames = person1.getSecondName().compareToIgnoreCase(person2.getSecondName());
                }
                return compareNames;

            }
        });

        for (PersonAddressPair personAddressPair : addressList){
            this.directory.put(personAddressPair.getPerson(),personAddressPair.getAddress());
        }
        //TODO convert addressList to a TreeMap assigned to directory.
    }

    public Optional<Address> getAddress(final Person person) {
        //FIXME
        return null;
    }

    public void updateAddress(final PersonAddressPair personAddress) {
        directory.replace(personAddress.getPerson(), personAddress.getAddress());
    }

    public void remove(final Person person) {
        directory.remove(person);
    }
}
