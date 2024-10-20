package com.senac.n1.exercicio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "produtos")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String desPro;
    @Column
    private Integer qtdeProduto;
    @Column
    private Double varProduto;
}
