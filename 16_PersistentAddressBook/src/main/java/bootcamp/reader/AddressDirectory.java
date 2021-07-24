package bootcamp.reader;

import bootcamp.data.*;
import bootcamp.db.AddressRowMapper;
import bootcamp.db.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class AddressDirectory {
    private final NamedParameterJdbcTemplate template;

    @Autowired
    public AddressDirectory(NamedParameterJdbcTemplate template){
        this.template = template;
    }

    /**
     * TODO
     * 1. If no address is returned, return the result with appropriate status and message.
     * 2. If address is returned, use the ID to create the parameters map for person query.
     * 3. Execute the query to get a list of people in the address.
     * 4. Package the results in the Residents object and return a Result instance.
     * 5. In case of errors, return an appropriate Result instance.
     */
    public Result<Residents> getResidents(final Address address) {
        final String addressSql = "SELECT * FROM ADDRESS WHERE LINE_1 = :firstLine AND LINE_2 = :secondLine " +
                "AND CITY = :city AND POST_CODE = :postCode";
        final String personSql = "SELECT * FROM PERSON WHERE ADDRESS_ID = :addressId";
        final Map<String, String> addressParams = Map.of(
                "firstLine", address.getFirstLine(),
                "secondLine", address.getSecondLine(),
                "city", address.getCity(),
                "postCode", address.getPostCode());

        final List<Address> addressFromDb = template.query(addressSql, addressParams, new AddressRowMapper());

        if (addressFromDb.size() == 0){
            return new Result<>(Status.INVALID_OPERATION);
        }

        final Map<String, Integer> personParams = Map.of(
                "addressId",addressFromDb.get(0).getId().get());
//        Optional<Integer> addressId = addressFromDb.get(0).getId();
        final List<Person> residentsFromDB = template.query(personSql,personParams,new PersonRowMapper());
        if (residentsFromDB.size() == 0){
            return new Result<>(Status.INVALID_OPERATION);
        }else{
            return new Result<>(Optional.of(new Residents(address,residentsFromDB)));
        }
    }



    public Result<PersonAddressPair> getAddress(final Person person) {
        final String personSql = "SELECT * FROM PERSON WHERE FIRST_NAME = :firstName AND LAST_NAME = :secondName";
        final String addressSql = "SELECT * FROM ADDRESS WHERE ID = :addressId";
        final Map<String, String> personParams = Map.of(
                "firstName",person.getFirstName(),
                "secondName",person.getSecondName());
        List<Person> personFromDB = template.query(personSql,personParams,new PersonRowMapper());
        if (personFromDB.size() == 0) {
            return new Result<>(Status.INVALID_OPERATION);
        }
        final Map<String,Integer> addressParam = Map.of("addressId",personFromDB.get(0).getAddressId().get());

        final List<Address> addressFromDB = template.query(addressSql,addressParam,new AddressRowMapper());

        if (addressFromDB.size() == 0){
            return new Result<>(Status.INVALID_OPERATION);
        }else {
            return new Result<>(Optional.of(new PersonAddressPair(person,addressFromDB.get(0))));
        }

        /**
         * TODO
         * 1. Create a Map<String, String> which contains the keys firstName and secondName and the first and second names
         * from the argument person.
         * 2. Execute the query method on the template giving it the personSql, the map in (1) and an instance of PersonRowMapper (you need to create one).
         * 3. If the person exists, take the address ID from the data returned.
         * 4. Create a Map<String, Integer> with addressID as key and ID from (3).
         * 5. Execute the query method on the template giving it the addressSql, the map in (4) and an instance of AddressRowMapper.
         * 6. Return the results.
         */
    }

}
