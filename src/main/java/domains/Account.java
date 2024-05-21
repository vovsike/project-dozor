package domains;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "account")
public class Account extends PanacheEntity {

    @Column(name = "user_name", nullable = false)
    public String userName;

    @Column(name = "email", unique = true, nullable = false)
    public String email;

    @Column(name = "active", nullable = false)
    public Boolean active;

    public static List<Account> findAlive() {
        return list("active", Boolean.TRUE);
    }

    public static Account findByUserName(String userName) {
        return find("userName", userName).firstResult();
    }

    public static Account findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public List<Account> findDeactivated() {
        return list("deactivated", Boolean.FALSE);
    }
}
