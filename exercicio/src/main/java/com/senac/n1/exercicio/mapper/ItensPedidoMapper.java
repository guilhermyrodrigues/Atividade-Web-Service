package com.senac.n1.exercicio.mapper;

import com.senac.n1.exercicio.dto.ItensPedidoDTO;
import com.senac.n1.exercicio.dto.ProdutoDTO;
import com.senac.n1.exercicio.model.ItensPedidoModel;
import com.senac.n1.exercicio.model.ProdutoModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItensPedidoMapper {
    // Converte de ItensPedidoDTO para ItensPedido (Entidade)
    ItensPedidoModel toEntity(ItensPedidoDTO dto);

    // Converte de ItensPedido (Entidade) para ItensPedidoDTO
    ItensPedidoDTO toDTO(ItensPedidoModel entity);

    // Atualiza uma entidade ItensPedido a partir de um DTO
    void updateEntityFromDTO(ItensPedidoDTO dto, @MappingTarget ItensPedidoModel entity);

    // Converte uma lista de entidades ItensPedido para uma lista de DTOs
    List<ItensPedidoDTO> toDTOList(List<ItensPedidoModel> entities);

    // Converte uma lista de DTOs para uma lista de entidades ItensPedido
    List<ItensPedidoModel> toEntityList(List<ItensPedidoDTO> dtos);
}
