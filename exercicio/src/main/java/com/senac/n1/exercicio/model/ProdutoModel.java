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
    @Column
    private String desPro;
    @Column
    private Integer qtdeProduto;
    @Column
    private Double varProduto;
}
