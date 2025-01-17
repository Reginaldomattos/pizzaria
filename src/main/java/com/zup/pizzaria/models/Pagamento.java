package com.zup.pizzaria.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import java.time.LocalDateTime;

@Entity
public class Pagamento {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "O ID do pedido não pode ser nulo.")
    private Long pedidoId;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "A forma de pagamento não pode ser nula.")
    private FormaPagamento formaPagamento;

    @NotNull(message = "O valor pago não pode ser nulo.")
    @min(value = 0, message = "O valor pago deve ser maior ou igual a zero.")
    private Double valorPago;

    @NotNull(message = "A data e hora do pagamento não podem ser nulas.")
    private LocalDateTime dataHoraPagamento;




}
