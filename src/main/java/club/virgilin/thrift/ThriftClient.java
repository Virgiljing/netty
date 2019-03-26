package club.virgilin.thrift;

import club.virgilin.thrift.generated.DataException;
import club.virgilin.thrift.generated.Person;
import club.virgilin.thrift.generated.PersonService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * ThriftClient
 *
 * @author virgilin
 * @date 2019/3/25
 */
public class ThriftClient {
    public static void main(String[] args) {
        TFramedTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 6000);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();
            Person person = client.getPersonByUsername("张三");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());


            System.out.println("-----------------");


            Person person1 = new Person();

            person1.setUsername("李四");
            person1.setAge(22);
            person1.setMarried(true);

            client.savePerson(person1);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }finally {
            transport.close();
        }
    }
}
