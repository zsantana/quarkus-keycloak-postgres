package br.com.xbinario.credcard.v1;

import java.util.UUID;

public record ResponseBalanceTransactionDTO(
    UUID id,
    String object,
    String amount,
    String available_on,
    String created,
    String currency,
    String description,
    String status
) {}
