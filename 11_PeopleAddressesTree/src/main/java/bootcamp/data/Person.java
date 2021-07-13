package bootcamp.data;

public class Person implements Comparable<Person> {
    private final String firstName ;
    private final String secondName ;

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person person) {

        int compareNames = this.firstName.compareToIgnoreCase(person.getFirstName());
        if (compareNames == 0){
            compareNames = this.secondName.compareToIgnoreCase(person.getSecondName());
        }
        return compareNames;

    }



    //TODO Constructor.
    //TODO getters.
    //TODO Fix the compilation error.

}
