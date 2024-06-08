package domains.person;

import domains.account.Account;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;

@ApplicationScoped
public class PersonService {

    public Person creatPerson(Person person) throws NoResultException {
        Account accountToLink = Account.findById(person.account.id);
        if (!accountToLink.isPersistent()) {
            throw new NoResultException();
        }
        person.account = accountToLink;
        person.persist();
        if (person.isPersistent()) {
            return person;
        }
        else throw new PersistenceException("Can't save person");
    }
}
