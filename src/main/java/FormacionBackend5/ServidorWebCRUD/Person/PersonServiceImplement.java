package FormacionBackend5.ServidorWebCRUD.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author pablo.delpozo
 *
 * Clase que implementa la interfaz servicio con el CRUD básico
 * No tiene conexión a BBDDD, los datos se almacenan en List
 * */
public class PersonServiceImplement implements PersonService{

    //Autowired con qualifier de la lista de personas, para atacar todos al mismo
    @Autowired
    @Qualifier("createPersonList")
    List<Person> persons;


    //Para generar id automaticamente e incrementando de uno en uno a partir de 1
    AtomicInteger atomicInteger=new AtomicInteger(1);


    /**
     * @param p de tipo Person
     * Recibe un objeto Person, le asigna un id automático, lo añade a la lista y muestra mensaje por consola
     *
     * */
    @Override
    public void addPerson(Person p) {

        //Asignamos id, y lo añadimos a la lista de personas
        p.setId(atomicInteger.getAndIncrement());
        persons.add(p);
        System.out.println("Persona añadida");

    }


    /**
     * @param id
     * @return List Person
     * Recibe un id, crea flujo para aplicar filtro por ese id y lo colecta
     *
     * */

    //Pasamos id y obtenemos aplicando filtro
    public List<Person> getPerson(int id) {

        //Creamos flujo para poder aplicar filtro
        Stream<Person> flujoPersonas = persons.stream();

        return flujoPersonas.filter(p -> p.getId() == id)
                .collect(Collectors.toList());
    }


    /***
     * @param id id de la persona a actualizar
     * @param name nombre de la persona a actualizar
     * @param city ciudad de la persona  a actualizar
     * @param age edad de la persona a  actualizar
     * @return la persona actualizada
     *
     * Este metodo recibe todos los datos de la persona a actualizar, la busca por id y se los cambia
     *
     *
     */


    @Override
    public Person updateForId(int id , String name, String city, int age) throws Exception{

        //Creamos flujo para poder aplicar filtro
        Stream<Person> flujoPersonas = persons.stream();

        List<Person> miPersona=flujoPersonas.filter(p -> p.getId() == id)
                .collect(Collectors.toList());

        //Si es 0 es que ese id no existe
        if (miPersona.size()<0){
            throw new Exception("Persona con ID: "+id+ " NO encontrada");
        }
        //si no, lo obtenemos
        Person personActualizar=miPersona.get(0);

        //Le actualizamos los atributos
        personActualizar.setName(name);
        personActualizar.setCity(city);
        personActualizar.setAge(age);

        //Mensaje informativo
        System.out.println("Persona actualizada");

        //Y por ultimo lo retornamos
        return personActualizar;


    }

    /**
     * @param id id de la persona a eliminar
     * @return la persona eliminada
     *
     * Recibe id, lo busca creando flujo y apliocando filtro, y cuando lo obtiene lo elimina
     * */
    //Obtenemos por id y lo eliminamos de la lista
    @Override
    public Person deleteForId(int id) throws  Exception {

        //Creamos flujo para poder aplicar filtro
        Stream<Person> flujoPersonas = persons.stream();

        List<Person> misPersonas=flujoPersonas.filter(p -> p.getId() == id)
                .collect(Collectors.toList());

        //Si es 0 es que ese id no existe
        if (misPersonas.size()<0){
            throw new Exception("Persona con ID: "+id+ " NO encontrada");
        }

        //si no, lo obtenemos
        Person personEliminar = misPersonas.get(0);

        //Lo eliminamos
        persons.remove(personEliminar);
        //Mensaje informativo
        System.out.println("Persona eliminada");

        //Y por ultimo ,lo retornamos
        return personEliminar;

    }


    /***
     * @return Lista de todas las personas
     */


    @Override
    public List<Person> getPersons() {

        System.out.println(persons);
        return persons;
    }
}
