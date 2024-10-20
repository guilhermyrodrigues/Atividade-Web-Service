package com.senac.n1.exercicio.mapper;

import com.senac.n1.exercicio.dto.ProdutoDTO;
import com.senac.n1.exercicio.model.ProdutoModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    // Converte de ProdutoDTO para Produto (Entidade)
    ProdutoModel toEntity(ProdutoDTO dto);

    // Converte de Produto (Entidade) para ProdutoDTO
    ProdutoDTO toDTO(ProdutoModel entity);

    // Atualiza uma entidade Produto a partir de um DTO
    void updateEntityFromDTO(ProdutoDTO dto, @MappingTarget ProdutoModel entity);

    // Converte uma lista de entidades Produto para uma lista de DTOs
    List<ProdutoDTO> toDTOList(List<ProdutoModel> entities);

    // Converte uma lista de DTOs para uma lista de entidades Produto
    List<ProdutoModel> toEntityList(List<ProdutoDTO> dtos);
}
