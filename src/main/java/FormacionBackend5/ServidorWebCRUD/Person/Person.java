package FormacionBackend5.ServidorWebCRUD.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pablo del Pozo
 *
 * Esta clase contiene atributos y gracias a Lombok, constructor lleno y otro vacio
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    //Atributos de la clase, id(se genera automatico), nombre, ciudad y edad
    private int id;
    private String name,
            city;
    private int age;
}
