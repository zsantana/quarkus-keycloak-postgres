package br.com.xbinario.credcard.v1;

import java.util.UUID;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "balance_transaction")
@RegisterForReflection
public class BalanceTransactionEntity extends PanacheEntityBase {
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(name = "object")
    private String object;

    @Column(name = "amount")
    private String amount;

    @Column(name = "available_on")
    private String available_on;

    @Column(name = "created")
    private String created;

    @Column(name = "currency")
    private String currency;

    @Column(name = "description")
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAvailable_on() {
        return available_on;
    }

    public void setAvailable_on(String available_on) {
        this.available_on = available_on;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
 }
