import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.Status;
import bootcamp.db.JdbcFactory;
import bootcamp.reader.AddressDirectory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersistentAddressBookTest {
    private static ApplicationContext ctx;
    private static AddressDirectory directory;

    @BeforeClass
    public static void setUp(){
        ctx = new AnnotationConfigApplicationContext(JdbcFactory.class);
        directory = ctx.getBean(AddressDirectory.class);
    }

    @Test
    public void ShouldReturnResidents(){
        Address address = new Address("25", "The Ridge", "Bedford", "MK17 3XS");
        directory.getResidents(address);
        assertEquals(Status.SUCCESS,directory.getResidents(address).getStatus());
    }

    @Test
    public void ShouldNotReturnResidents(){
        Address address = new Address("46", "First Line", "Second Line", "MK17 3XS");
        directory.getResidents(address);
        assertEquals(Status.INVALID_OPERATION,directory.getResidents(address).getStatus());
    }

    @Test
    public void ShouldReturnAnAddress(){
        Person person = new Person("Alex","Smith");
        assertTrue(directory.getAddress(person).getValue().isPresent());
    }

    @Test
    public void ShouldNotReturnAnAddress(){
        Person person = new Person("Jack","Grealish");
        assertEquals("No such an record found",directory.getAddress(person).getStatusMessage());
    }

}
