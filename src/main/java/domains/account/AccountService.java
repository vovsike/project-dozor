package domains.account;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AccountService {

    public List<Account> getActiveAccounts() {
        return Account.findAlive();
    }

    public Account getAccountById(Long id) {
        Optional<Account> accountOptional = Account.findByIdOptional(id);
        return accountOptional.orElseThrow(NotFoundException::new);
    }

    public Account createNewAccount(Account account) {
        account.id = null;
        account.active = true;
        account.persist();
        if (account.isPersistent()) {
            return account;
        }
        else throw new InternalServerErrorException();
    }

    public Account updateAccount(Long id, Account account) {
        Account entity = Account.findById(id);
        entity.email = account.email;
        entity.userName = account.userName;
        entity.active = account.active;
        return Account.findById(entity.id);
    }
}
