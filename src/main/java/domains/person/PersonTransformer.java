package domains.person;

import domains.account.Account;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonTransformer {

    public static PersonDTO toDTO(Person person) {
        return new PersonDTO(
                person.id, person.name, person.account.id, person.type
        );
    }

    public static Person toEntity(PersonDTO personDTO) {
        Person person = new Person();
        person.name = personDTO.name();
        person.account = new Account();
        person.account.id = personDTO.accountId();
        person.type = personDTO.type();
        return person;
    }
}
