package bootcamp.data;

import java.util.List;

public class Residents {
    private final Address address ;
    private final List<Person> residents ;

    public Residents(Address address, List<Person> residents) {
        this.address = address;
        this.residents = residents;
    }

    public Address getAddress() {
        return address;
    }

    public List<Person> getResidents() {
        return residents;
    }

    @Override
    public String toString() {
        return "Residents{" +
                "address=" + address +
                ", residents=" + residents +
                '}';
    }

    //TODO Constructor
    //TODO Getters
}
