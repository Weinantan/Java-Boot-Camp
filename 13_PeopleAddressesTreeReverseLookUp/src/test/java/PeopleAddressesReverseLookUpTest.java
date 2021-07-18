package test.java;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;
import main.java.bootcamp.directory.AddressDirectory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PeopleAddressesReverseLookUpTest {
    private List<PersonAddressPair> addresslist;
    AddressDirectory directory;

    @Before
    public void setUp(){
        addresslist = new ArrayList<>();
        addresslist.add(new PersonAddressPair(new Person("Wayne","Tan"),new Address("first line1","second line 1", "ABC1", "city1" )));
        addresslist.add(new PersonAddressPair(new Person("Wayne2","Tan2"),new Address("first line1","second line 1", "ABC1", "city1" )));
        addresslist.add(new PersonAddressPair(new Person("Wayne3","Tan3"),new Address("first line1","second line 1", "ABC1", "city1" )));

        addresslist.add(new PersonAddressPair(new Person("Jack","Grealish"),new Address("first line2","second line 2", "ABC2", "city2" )));
        addresslist.add(new PersonAddressPair(new Person("Harry","Kane"),new Address("first line3","second line 3", "ABC3", "city3" )));
        addresslist.add(new PersonAddressPair(new Person("Jordan","Pickford"),new Address("first line4","second line 4", "ABC4", "city4" )));

        directory = new AddressDirectory(addresslist);
    }

    @Test
    public void ShouldReturnAddressIfPersonExists(){
       Address address = directory.getAddress(new Person("Wayne","Tan")).get();
       assertEquals(new Address("first line1","second line 1", "ABC1", "city1" ),address);
    }

    @Test
    public void ShouldNotReturnAddressIfPersonNotExists(){
        Person person = new Person("Jordan","Sanchos");
        assertEquals(Optional.empty(),directory.getAddress(person));
    }

    @Test
    public void ShouldUpdatesAPersonAddressWhenExists(){

        Person person = new Person("Jack","Grealish");
        Address newAddress = new Address("22","London Road","GU149TZ","Farnborough");
        PersonAddressPair myNewAddress = new PersonAddressPair(person,newAddress);
        directory.updateAddress(myNewAddress);
        assertEquals(Optional.of(newAddress),directory.getAddress(person));

    }

    @Test
    public void ShouldUpdatesPersonAddressWhenPersonDoesNotExistInTheDirectory(){
        //Laura's code
            Person person = new Person("No Person", "Baker");
            Address newAddress = new Address("line1B", "", "", "");
            List<Person> peopleBefore = directory.getPersonAtAddress(newAddress);
            assertEquals(false, peopleBefore.contains(person));
            directory.updateAddress(new PersonAddressPair(person, newAddress));
            List<Person> peopleAfter = directory.getPersonAtAddress(newAddress);
            assertEquals(true, peopleAfter.contains(person));
            assertTrue(directory.getPersonAtAddress(newAddress).contains(person));
    }

    @Test
    public void ShouldRemovePersonAddress(){
        Person person = new Person("Wayne", "Tan");
        assertEquals(Status.SUCCESS, directory.remove(person));
    }


    // Tests after the reverse Look up implementation.
    @Test
    public void ShouldReturnAllPeopleAtAnAddress() {
        Address address = new Address("first line1","second line 1", "ABC1", "city1" );
        //3 people lives at "address"
        List<Person> result = directory.getPersonAtAddress(address);
        assertEquals(3, result.size());
    }

    @Test
    public void ShouldReturnEmptyListForNonexistentAddress() {
        Address address = new Address("12das","dasd line 1", "ABC1", "Farnborough" );
        List<Person> result = directory.getPersonAtAddress(address);
        assertEquals(true, result.isEmpty());
    }


    @Test
    public void ShouldReturnKeyNotFoundForNonExistingAddressUpdate() {
        Address newAddress = new Address("Not a real address","Not a real address line 1", "ABC1", "city1" );
        Address oldAddress = new Address("Not a real address","Not a real address", "Not a real address", "Not a real address" );
        assertEquals(Status.FAILED_NO_KEY_FOUND, directory.updateAddress(oldAddress, newAddress));
    }


    @Test
    public void ShouldRemoveAddressAndCorrespondingPeople() {
        Address address = new Address("first line1","second line 1", "ABC1", "city1" );
        assertEquals(Status.SUCCESS, directory.remove(address));
        assertTrue(directory.getPersonAtAddress(address).isEmpty());

    }
    @Test
    public void ShouldReturnKeyNotFoundForNonExistingAddressRemove() {
        Address address = new Address("Non existing","Not a real address", "Not a real address", "Not a real address" );
        assertEquals(Status.FAILED_NO_KEY_FOUND, directory.remove(address));

    }


    // Source Code From Laura
    @Test
    public void ShouldUpdateAddressForAllResidents_Success() {
        Address newAddress = new Address("first line12345","second line 1", "ABC1", "city1" );
        Address oldAddress = new Address("first line1","second line 1", "ABC1", "city1" );
        List<Person> oldResidents = directory.getPersonAtAddress(oldAddress);
        assertEquals(Status.SUCCESS,directory.updateAddress(oldAddress, newAddress));
        List<Person> newResidents = directory.getPersonAtAddress(newAddress);
        assertEquals(oldResidents.size(), newResidents.size());
        assertTrue(directory.getPersonAtAddress(oldAddress).isEmpty());
        for (Person person: oldResidents) {
            assertEquals(directory.getAddress(person).get(), newAddress);
        }
    }





}
