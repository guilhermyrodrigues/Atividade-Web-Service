package com.senac.n1.exercicio.mapper;

import com.senac.n1.exercicio.dto.ProdutoDTO;
import com.senac.n1.exercicio.model.ProdutoModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-19T17:45:36-0300",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public ProdutoModel toEntity(ProdutoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ProdutoModel produtoModel = new ProdutoModel();

        produtoModel.setId( dto.getId() );
        produtoModel.setDesPro( dto.getDesPro() );
        produtoModel.setQtdeProduto( dto.getQtdeProduto() );
        produtoModel.setVarProduto( dto.getVarProduto() );

        return produtoModel;
    }

    @Override
    public ProdutoDTO toDTO(ProdutoModel entity) {
        if ( entity == null ) {
            return null;
        }

        ProdutoDTO produtoDTO = new ProdutoDTO();

        produtoDTO.setId( entity.getId() );
        produtoDTO.setDesPro( entity.getDesPro() );
        produtoDTO.setQtdeProduto( entity.getQtdeProduto() );
        produtoDTO.setVarProduto( entity.getVarProduto() );

        return produtoDTO;
    }

    @Override
    public void updateEntityFromDTO(ProdutoDTO dto, ProdutoModel entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        entity.setDesPro( dto.getDesPro() );
        entity.setQtdeProduto( dto.getQtdeProduto() );
        entity.setVarProduto( dto.getVarProduto() );
    }

    @Override
    public List<ProdutoDTO> toDTOList(List<ProdutoModel> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ProdutoDTO> list = new ArrayList<ProdutoDTO>( entities.size() );
        for ( ProdutoModel produtoModel : entities ) {
            list.add( toDTO( produtoModel ) );
        }

        return list;
    }

    @Override
    public List<ProdutoModel> toEntityList(List<ProdutoDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ProdutoModel> list = new ArrayList<ProdutoModel>( dtos.size() );
        for ( ProdutoDTO produtoDTO : dtos ) {
            list.add( toEntity( produtoDTO ) );
        }

        return list;
    }
}
