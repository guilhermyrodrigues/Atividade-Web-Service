package com.senac.n1.exercicio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nroPEDIDO")
    private Long nroPedido;
    @Column(name = "datPEDIDO")
    private LocalDateTime datPedido;
}
