package com.zup.pizzaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Pagamento {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "O ID do pedido não pode ser nulo.")
    private Long pedidoId;


}
