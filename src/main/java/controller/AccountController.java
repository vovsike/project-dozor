package controller;

import domains.account.Account;
import domains.account.AccountDTO;
import domains.account.AccountService;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Path("/accounts")
@Transactional
public class AccountController {

    private static final Logger logger = Logger.getLogger(AccountController.class);
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AccountController.class);

    @Inject
    AccountService service;

    @GET
    @Path("/{id}")
    @Blocking
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AccountDTO getAccounts(@PathParam("id") Long id) {
        logger.info("getAccountCalled");
        return AccountDTO.from(service.getAccountById(id));
    }


    @GET
    public List<AccountDTO> listAccounts() {
        logger.info("getAccounts");
        return AccountDTO.from(service.getActiveAccounts());
    }

    @POST
    public Response createAccount(@Valid AccountDTO dto) {
        Account createdAccount = service.createNewAccount(Account.from(dto));
        return Response.status(Response.Status.CREATED).entity(AccountDTO.from(createdAccount)).build();
    }

    @PATCH
    @Path("/{id}")
    @Blocking
    @Consumes(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AccountDTO patchStudents(@PathParam("id") Long id, AccountDTO accountDTO) {
        logger.info(accountDTO);
        return accountDTO;
    }
}
