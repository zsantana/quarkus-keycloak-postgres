package br.com.xbinario.credcard.v1;

public record RequestBalanceTransactionDTO(
    String object,
    String amount,
    String available_on,
    String created,
    String currency,
    String description
) {}
