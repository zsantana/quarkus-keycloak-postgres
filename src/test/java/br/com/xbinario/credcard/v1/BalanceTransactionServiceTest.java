package br.com.xbinario.credcard.v1;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@QuarkusTest
public class BalanceTransactionServiceTest {

    // @InjectMock
    // BalanceTransactionEntity balanceTransactionEntity; // You may need to adjust this based on your actual entity class

    // @InjectMock
    // BalanceTransactionService balanceTransactionService;

    // @Test
    // public void testGetTransactionFound() {
    //     // Mocking findById method to return a dummy entity
    //     Mockito.when(balanceTransactionEntity.findById(any(UUID.class)))
    //             .thenReturn(Uni.createFrom().item(new BalanceTransactionEntity()));

    //     Uni<Response> responseUni = balanceTransactionService.getTransaction("some-id");

    //     Response response = responseUni.await().indefinitely();
    //     assertEquals(Status.OK.getStatusCode(), response.getStatus());
    // }

    // @Test
    // public void testGetTransactionNotFound() {
    //     // Mocking findById method to return null
    //     Mockito.when(balanceTransactionEntity.findById(any(UUID.class)))
    //             .thenReturn(Uni.createFrom().nullItem());

    //     Uni<Response> responseUni = balanceTransactionService.getTransaction("non-existing-id");

    //     Response response = responseUni.await().indefinitely();
    //     assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
    // }

    
}
