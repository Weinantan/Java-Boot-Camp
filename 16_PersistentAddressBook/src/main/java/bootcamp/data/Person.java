package bootcamp.data;

import java.util.Objects;
import java.util.Optional;

public class Person {
    private final String firstName ;
    private final String secondName ;
    private final Optional<Integer> id ;
    private final Optional<Integer> addressId ;


    public Person(String firstName, String secondName, Optional<Integer> id, Optional<Integer> addressId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.id = id;
        this.addressId = addressId;
    }

    //One as query for a person containing only first and second names;
    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.id = getId();
        this.addressId = getAddressId();
    }

    //second for the response to the query containing the IDs from the database.
    public Person(Optional<Integer> id, Optional<Integer> addressId) {
        this.id = id;
        this.addressId = addressId;
        this.firstName = getFirstName();
        this.secondName = getSecondName();
    }

    //TODO 2 constructors, one as query for a person containing only first and second names and the second for the
    // response to the query, containing the IDs from the database.
    //TODO getters.


    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Optional<Integer> getId() {
        return id;
    }

    public Optional<Integer> getAddressId() {
        return addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(secondName, person.secondName) && Objects.equals(id, person.id) && Objects.equals(addressId, person.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, id, addressId);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
