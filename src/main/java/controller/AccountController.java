package controller;

import domains.AccountDTO;
import domains.AccountService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Path("/accounts")
@Transactional
public class AccountController {

    @Inject
    AccountService service;

    @GET
    public List<AccountDTO> getAccounts() {
        return AccountDTO.from(service.getActiveAccounts());
    }

    @GET
    @Path("{id}")
    public AccountDTO getAccount(@RestPath String id) {
        return AccountDTO.from(service.getAccountById(id));
    }

    @POST
    public Response createAccount(AccountDTO dto) {
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
}
