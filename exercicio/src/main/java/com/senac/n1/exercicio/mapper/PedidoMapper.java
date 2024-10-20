package com.senac.n1.exercicio.mapper;

import com.senac.n1.exercicio.dto.PedidoDTO;
import com.senac.n1.exercicio.dto.ProdutoDTO;
import com.senac.n1.exercicio.model.PedidoModel;
import com.senac.n1.exercicio.model.ProdutoModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    // Converte de PedidoDTO para Pedido (Entidade)
    PedidoModel toEntity(PedidoDTO dto);

    // Converte de Pedido (Entidade) para PedidoDTO
    PedidoDTO toDTO(PedidoModel entity);

    // Atualiza uma entidade Pedido a partir de um DTO
    void updateEntityFromDTO(PedidoDTO dto, @MappingTarget PedidoModel entity);

    // Converte uma lista de entidades Pedido para uma lista de DTOs
    List<PedidoDTO> toDTOList(List<PedidoModel> entities);

    // Converte uma lista de DTOs para uma lista de entidades Pedido
    List<PedidoModel> toEntityList(List<PedidoDTO> dtos);
}
