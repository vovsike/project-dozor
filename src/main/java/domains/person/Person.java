package domains.person;

import domains.account.Account;
import embeded.PersonName;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class Person extends PanacheEntityBase {

    @Id
    public Long id;

    public PersonName name;

    @Enumerated(EnumType.STRING)
    public PersonType type;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    public Account account;
}
