package FormacionBackend5.ServidorWebCRUD.Person;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pablo.delpozo
 *
 * Interfaz de servicio, contiene todos los metodos necesarios para un CRUD básico
 * */
@Service
public interface PersonService {

    public void addPerson(Person p);

    public List<Person> getPerson(int id);

    public Person updateForId(int id, String name, String city, int age)throws Exception;

    public Person deleteForId(int id) throws  Exception ;


    public List<Person> getPersons();
}
