package FormacionBackend5.ServidorWebCRUD.Controllers;

import FormacionBackend5.ServidorWebCRUD.Person.Person;
import FormacionBackend5.ServidorWebCRUD.Person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pablo.delpozo
 * <p>
 * Esta clase realiza la funcion de controlador REST
 * <p>
 * Tiene dos autowired, de la interfaz PersonService, y otro con la lista de personas
 */
@RestController
public class Controllers {

    @Autowired
    PersonService personService;

    @Autowired
    @Qualifier("createPersonList")
    List<Person> persons;


    /**
     * @param p objeto de tipo person en el body del mensaje
     *          al realizar peticion post con addPerson y pasandole un obtejo person ene el body, se lo pasamos a addPerson de PersonService
     */
    @PostMapping("addPerson")
    public void addPerson(@RequestBody Person p) {

        personService.addPerson(p);
    }

    /**
     * @param id id de la persona a obtener
     * @return la persona con el id pasado por parametro
     * Solicita id en el path por peticion GET y llamamos a getPerson
     */

    @GetMapping("getPerson/{id}")
    public List<Person> getPerson(@PathVariable int id) {
        return personService.getPerson(id);
    }


    /**
     * * @param id id de la persona a actualizar
     *
     * @param name nombre de la persona a actualizar
     * @param city ciudad de la persona  a actualizar
     * @param age  edad de la persona a  actualizar
     * @return la persona actualizada
     * Solicita id y los campos a actualizar, con ello llamamos a personService.updateForId
     */
    @PutMapping("updatePerson/{id}/{name}/{city}/{age}")
    public void updatePersonForId(@PathVariable int id, @PathVariable String name, @PathVariable String city, @PathVariable int age) throws Exception {

        personService.updateForId(id, name, city, age);

    }

    /**
     * @param id id de la persona a eliminar
     * @return la persona eliminada
     *
     * Recibe id y se lo manda a person Service.deleteForId
     * */
    @DeleteMapping("deletePerson/{id}")
    public void deletePersonForId(@PathVariable int id) throws Exception {

        personService.deleteForId(id);
    }


    /**
     * @return lista de todas las personas de la lista
     * */
    @GetMapping("getPersons")
    public List<Person> getPersons() {
        return personService.getPersons();
    }
}

