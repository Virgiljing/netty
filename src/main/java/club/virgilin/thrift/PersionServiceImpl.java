package club.virgilin.thrift;

import club.virgilin.thrift.generated.DataException;
import club.virgilin.thrift.generated.Person;
import club.virgilin.thrift.generated.PersonService;
import org.apache.thrift.TException;

/**
 * PersionServiceImpl
 *
 * @author virgilin
 * @date 2019/3/25
 */
public class PersionServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Got Client Param: " + username);
        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Got Client Param: ");
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
