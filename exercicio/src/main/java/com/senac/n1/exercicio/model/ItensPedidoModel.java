package com.senac.n1.exercicio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "itens-pedido")
public class ItensPedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer qtdeItem;
    @Column
    private Double valUnidade;
}
