import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.directory.AddressDirectory;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class PeopleAddressesTest {
    private List<PersonAddressPair> addresslist;
    private Map<Person,Address> directory = new HashMap<>();

    @Before
    public void setUp(){
        Person JackOliver = new Person("Jack","Oliver");
        Person AmyHose = new Person("Amy","Hose");
        Person RyanJackson = new Person("Ryan","Jackson");

        Address address = new Address("22","Tower Hill","GU140BJ","Farnborough");
        Address address1 = new Address("46","Cove Road","GU140EN","Farnborough");
        Address address2= new Address("115","Cove Road","GU140EN","Farnborough");

        addresslist = new ArrayList<>(Arrays.asList(new PersonAddressPair(JackOliver,address),
                new PersonAddressPair(AmyHose,address1),new PersonAddressPair(RyanJackson,address2)));


    }

    @Test
    public void ShouldReturnAddressIfPersonExists(){
        AddressDirectory addressDirectory = new AddressDirectory(addresslist, directory);
        Person person = new Person("Jack","Oliver");
        Address address = new Address("22","Tower Hill","GU140BJ","Farnborough");
        assertEquals(Optional.of(address),addressDirectory.getAddress(person));
    }

    @Test
    public void ShouldNotReturnAddressIfPersonNotExists(){
        AddressDirectory addressDirectory = new AddressDirectory(addresslist, directory);
        Person person = new Person("Jack","Grealish");
        assertEquals(Optional.empty(),addressDirectory.getAddress(person));
    }

    @Test
    public void ShouldUpdatesAPersonAddressWhenExists(){
        AddressDirectory addressDirectory = new AddressDirectory(addresslist, directory);
        Person person = new Person("Jack","Oliver");
        Address newAddress = new Address("22","London Road","GU149TZ","Farnborough");
        PersonAddressPair myNewAddress = new PersonAddressPair(person,newAddress);
        addressDirectory.updateAddress(myNewAddress);
        assertEquals(Optional.of(newAddress),addressDirectory.getAddress(person));

    }

    @Test
    public void ShouldUpdatesPersonAddressWhenPersonDoesNotExistInTheDirectory(){
        AddressDirectory addressDirectory = new AddressDirectory(addresslist, directory);
        Person person = new Person("Jack","Grealish");
        Address address = new Address("485","Victoria Road","GU148QQ","Farnborough");
        PersonAddressPair newAddress = new PersonAddressPair(person,address);
        addressDirectory.updateAddress(newAddress);
        assertTrue(directory.containsKey(person));
    }

    @Test
    public void ShouldRemovePersonAddress(){
        AddressDirectory addressDirectory = new AddressDirectory(addresslist, directory);
        Person person = new Person("Jack","Oliver");
        addressDirectory.remove(person);
        System.out.println(addressDirectory.toString());

        assertEquals(Optional.empty(),addressDirectory.getAddress(person));
    }





}
