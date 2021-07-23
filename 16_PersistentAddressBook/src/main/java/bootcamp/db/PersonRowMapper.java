package bootcamp.db;

import bootcamp.data.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String firstName = rs.getString("FIRST_NAME");
        final String secondName = rs.getString("LAST_NAME");
//        final int id  = rs.getInt("ID");
//        final int address_id = rs.getInt("ADDRESS_ID");
        return new Person(firstName,secondName);
    }
}
