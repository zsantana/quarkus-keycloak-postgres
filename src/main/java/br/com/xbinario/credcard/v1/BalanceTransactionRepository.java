package br.com.xbinario.credcard.v1;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BalanceTransactionRepository implements PanacheRepository<BalanceTransactionEntity>  {
    
    public Uni<BalanceTransactionEntity> findById(String id){
        return find("id", id).firstResult();
    }
    
}
