package com.senac.n1.exercicio.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PedidoDTO {
    private Integer id;
    private Long nroPedido;
    private LocalDateTime datPedido;
}
