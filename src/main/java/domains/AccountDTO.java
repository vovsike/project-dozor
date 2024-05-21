package domains;

import java.util.List;
import java.util.stream.Collectors;

public record AccountDTO(String userName, String email, Boolean active) {

    public static AccountDTO from(Account account) {
        return new AccountDTO(account.userName, account.email, account.active);
    }

    public static List<AccountDTO> from(List<Account> accounts) {
        return accounts.stream().map(AccountDTO::from).collect(Collectors.toList());
    }
}
