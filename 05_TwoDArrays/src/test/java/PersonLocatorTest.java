import bootcamp.data.Location;
import bootcamp.data.Person;
import bootcamp.process.PersonLocator;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PersonLocatorTest {

//    @Test
//    public void BeingAbleToLocateAValueInTheTwoDArray(){
//            Person[][] people = {{new Person("John", "Smith"), new Person("Jack", "Jones"), new Person("Mat", "Lil")},
//                    {new Person("FN10", "LN10"), new Person("FN11", "LN11"), new Person("FN12", "LN12")}};
//            PersonLocator locator = new PersonLocator(people);
//
//            assertEquals(Optional.of(new Location(0,0)), locator.find(new Person("John", "Smith")));
//        }


    @Test
    public void NotBeingAbleToLocateAValueInTheTwoDArray(){
        Person[][] people = {{new Person("John", "Smith"), new Person("Jack", "Jones"), new Person("Mat", "Lil")},
                {new Person("Kane", "Muller"), new Person("Sam", "Huggin"), new Person("Kiran", "Smith")}};
        PersonLocator locator = new PersonLocator(people);

        assertNotEquals(Optional.of(new Location()), locator.find(new Person("Sam", "Smith")));
    }

    @Test
    public void Test() {
        Person[][] people = {{new Person("John", "Smith"), new Person("Jack", "Jones"), new Person("Mat", "Lil")},
                {new Person("Kane", "Muller"), new Person("Sam", "Huggin"), new Person("Kiran", "Smith")}};
        PersonLocator locator = new PersonLocator(people);

        assertEquals(true,locator.find(new Person("Jack","Jones")).isPresent());
    }
}
