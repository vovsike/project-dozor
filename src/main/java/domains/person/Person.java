package domains.person;

import domains.account.Account;
import embeded.PersonName;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class Person extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "person_generator", sequenceName = "person_seq")
    public Long id;

    public PersonName name;

    @Enumerated(EnumType.STRING)
    public PersonType type;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    public Account account;
}
