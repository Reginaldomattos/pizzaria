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

    //Construtores
    public Pagamento() {

    }

    public Pagamento(Long pedidoId, FormaPagamento formaPagamento, Double valorPago, LocalDateTime dataHoraPagamento) {
        this.pedidoId = pedidoId;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
        this.dataHoraPagamento = dataHoraPagamento;

    }

    // Getters e Setters
    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;

    }

    public Long getPedidoId() {
        return pedidoId;

    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;

    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;

    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;

    }

    public Double getValorPago() {
        return valorPago;

    }

    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;

    }

    public void setDataHoraPagamento(localDateTime dataHoraPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;

    }

    // Método para validar o pagamento
    public void validarPagamento(Double valorTotalPedido) {
        if (this.valorPago < valorTotalPedido) {
            throw new IllegalArgumentException("O valor pago não pode ser menor que o valor total do pedido.");

        }
    }


}
