package domains.teacher;

import domains.account.Account;
import embeded.PersonName;
import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    Long id;

    public PersonName name;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    public Account account;
}
