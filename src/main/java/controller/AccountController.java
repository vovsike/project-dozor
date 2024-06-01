package controller;

import domains.account.Account;
import domains.account.AccountDTO;
import domains.account.AccountService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class AccountController {


    @Inject
    AccountService service;

    @GET
    @Path("/{id}")
    public AccountDTO getAccounts(@PathParam("id") Long id) {
        return AccountDTO.from(service.getAccountById(id));
    }

    @GET
    @Path("/active")
    public List<AccountDTO> getActiveAccounts() {
        List<Account> accountList = service.getActiveAccounts();
        return AccountDTO.from(accountList);
    }

    @GET
    public AccountDTO listAccounts(@QueryParam("name") String name) {
        return AccountDTO.from(service.getAccountByName(name));
    }

    @POST
    public Response createAccount(@Valid AccountDTO dto) {
        Account createdAccount = service.createNewAccount(Account.from(dto));
        return Response.status(Response.Status.CREATED).entity(AccountDTO.from(createdAccount)).build();
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AccountDTO patchStudents(@PathParam("id") Long id, AccountDTO accountDTO) {
        return accountDTO;
    }

    @PATCH
    @Path("/{id}")
    @Consumes("application/merge-patch+json")
    @Produces(MediaType.APPLICATION_JSON)
    public AccountDTO mergePatchStudents(@PathParam("id") Long id, AccountDTO accountDTO) {
        return AccountDTO.from(service.updateAccount(id,Account.from(accountDTO)));
    }
}
