package domains.student;

import domains.account.Account;
import embeded.PersonName;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student extends PanacheEntityBase {

    @Id
    public Long id;

    public PersonName name;

    @OneToOne(optional = false, fetch= FetchType.LAZY)
    @MapsId
    public Account account;
}
