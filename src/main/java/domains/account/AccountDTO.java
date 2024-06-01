package domains.account;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.stream.Collectors;

public record AccountDTO(@NotNull Long id,
                         @NotNull @NotBlank String userName,
                         @NotNull @NotBlank @Email String email,
                         Boolean active) {

    public static AccountDTO from(Account account) {
        return new AccountDTO(account.id,account.userName, account.email, account.active);
    }

    public static List<AccountDTO> from(List<Account> accounts) {
        return accounts.stream().map(AccountDTO::from).collect(Collectors.toList());
    }
}
