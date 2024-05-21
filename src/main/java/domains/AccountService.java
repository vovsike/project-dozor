package domains;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AccountService {

    public List<Account> getActiveAccounts() {
        return Account.findAlive();
    }

    public Account getAccountById(String id) {
        Optional<Account> accountOptional = Account.findByIdOptional(id);
        return accountOptional.orElseThrow(NotFoundException::new);
    }
}
