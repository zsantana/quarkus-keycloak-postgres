package br.com.xbinario.credcard.v1;

import java.util.UUID;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.runtime.annotations.RegisterForReflection;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@ApplicationScoped
@RegisterForReflection
public class BalanceTransactionService {


    @WithSession
    public Uni<Long> getTotal (){
        return BalanceTransactionEntity.count();
    }


    @WithSession
    public Uni<Response> getTransaction (String id){
        return BalanceTransactionEntity.<BalanceTransactionEntity>findById(UUID.fromString(id))
                    .onItem().ifNotNull().transform(entity -> Response.ok(entity).build())
                    .onItem().ifNull().continueWith(Response.status(Status.NOT_FOUND)::build);
    }


    public Uni<Response> postTransaction(RequestBalanceTransactionDTO dto) {
        return buildResponse(persistBalanceTransaction(createBalanceTransactionEntity(dto)));
    }
    
    private BalanceTransactionEntity createBalanceTransactionEntity(RequestBalanceTransactionDTO dto) {
        BalanceTransactionEntity dao = new BalanceTransactionEntity();
        dao.setAmount(dto.amount());
        dao.setAvailable_on(dto.available_on());
        dao.setCreated(dto.created());
        dao.setCurrency(dto.currency());
        dao.setDescription(dto.description());
        return dao;
    }
    
    private Uni<BalanceTransactionEntity> persistBalanceTransaction(BalanceTransactionEntity dao) {
        return Panache.withTransaction(dao::persist);
    }
    
    private Uni<Response> buildResponse(Uni<BalanceTransactionEntity> daoUni) {
        return daoUni.map(this::mapToResponse)
                .onItem().transform(responseDTO -> Response.ok(responseDTO).build())
                .onItem().ifNull().continueWith(() -> Response.status(Status.NOT_FOUND).build());
    }

    private ResponseBalanceTransactionDTO mapToResponse(BalanceTransactionEntity dao) {
        return new ResponseBalanceTransactionDTO(
                dao.getId(),
                dao.getObject(),
                dao.getAmount(),
                dao.getAvailable_on(),
                dao.getCreated(),
                dao.getCurrency(),
                dao.getDescription(),
                "CREATED"
        );
    }
    
}
