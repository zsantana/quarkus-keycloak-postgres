package br.com.xbinario.credcard.v1;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.annotations.RegisterForReflection;
import io.smallrye.mutiny.Uni;

@Path("/api/v1/balance_transactions")
@RegisterForReflection
public class BalanceTransactionResource {


    private static Logger log = LoggerFactory.getLogger(BalanceTransactionResource.class);

    
    @Inject
    private BalanceTransactionService balanceTransactionService;  

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/total")
    public Uni<Long> getTotal() {
        return balanceTransactionService.getTotal();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @RolesAllowed("USER")
    public Uni<Response> getTransaction(String id) {
        // log.info("### receive request get {}", id);
        return balanceTransactionService.getTransaction(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("ADMIN")
    public Uni<Response> postTransaction(RequestBalanceTransactionDTO dto) {
        // log.info("### receive request post {}", dto);
        return balanceTransactionService.postTransaction(dto);
    }


}
