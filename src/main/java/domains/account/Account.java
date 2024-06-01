package domains.account;

import domains.student.Student;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "account")
@NamedQueries({
        @NamedQuery(name= "Account.getByStudentName", query = "from Account as a join a.student as s where s.name.firstName = ?1")
})
public class Account extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="account_generator", sequenceName = "account_seq")
    public Long id;

    @Column(name = "user_name", nullable = false)
    public String userName;

    @Column(name = "email", unique = true, nullable = false)
    public String email;

    @Column(name = "active", nullable = false)
    public Boolean active;

    @OneToOne(mappedBy = "account")
    public Student student;

    public Account() {
    }

    public Account(String userName, String email, Boolean active) {
        this.userName = userName;
        this.email = email;
        this.active = active;
    }

    public static List<Account> findAlive() {
        return list("active", Boolean.TRUE);
    }

    public static Account from (AccountDTO dto) {
        return new Account(dto.userName(), dto.email(), dto.active());
    }

    public static Account findByName(String name) {
        return find("#Account.getByStudentName", name).firstResult();
    }
}
