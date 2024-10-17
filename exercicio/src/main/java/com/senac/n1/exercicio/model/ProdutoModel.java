package com.senac.n1.exercicio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "produto")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "descriPRODUTO")
    private String descriPro;
    @Column(name = "qtdePRODUTO")
    private Integer qtdeProduto;
    @Column(name = "valorPRODUTO")
    private Double valorProduto;
}
