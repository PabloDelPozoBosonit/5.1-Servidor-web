package FormacionBackend5.ServidorWebCRUD.MyConfiguration;

import FormacionBackend5.ServidorWebCRUD.Person.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pablo.delpozo
 *
 * Esta clase contiene un bean de la lista de personas de tipo Person
 *
 * */
@Configuration
public class MyConfiguration {
    @Bean
    public List<Person> createPersonList() {

        return new ArrayList<Person>();
    }
}
