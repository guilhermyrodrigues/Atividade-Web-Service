package com.senac.n1.exercicio.mapper;

import com.senac.n1.exercicio.dto.ItensPedidoDTO;
import com.senac.n1.exercicio.model.ItensPedidoModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-19T20:38:34-0300",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class ItensPedidoMapperImpl implements ItensPedidoMapper {

    @Override
    public ItensPedidoModel toEntity(ItensPedidoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ItensPedidoModel itensPedidoModel = new ItensPedidoModel();

        itensPedidoModel.setId( dto.getId() );
        itensPedidoModel.setQtdeItem( dto.getQtdeItem() );
        itensPedidoModel.setValUnidade( dto.getValUnidade() );

        return itensPedidoModel;
    }

    @Override
    public ItensPedidoDTO toDTO(ItensPedidoModel entity) {
        if ( entity == null ) {
            return null;
        }

        ItensPedidoDTO itensPedidoDTO = new ItensPedidoDTO();

        itensPedidoDTO.setId( entity.getId() );
        itensPedidoDTO.setQtdeItem( entity.getQtdeItem() );
        itensPedidoDTO.setValUnidade( entity.getValUnidade() );

        return itensPedidoDTO;
    }

    @Override
    public void updateEntityFromDTO(ItensPedidoDTO dto, ItensPedidoModel entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        entity.setQtdeItem( dto.getQtdeItem() );
        entity.setValUnidade( dto.getValUnidade() );
    }

    @Override
    public List<ItensPedidoDTO> toDTOList(List<ItensPedidoModel> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ItensPedidoDTO> list = new ArrayList<ItensPedidoDTO>( entities.size() );
        for ( ItensPedidoModel itensPedidoModel : entities ) {
            list.add( toDTO( itensPedidoModel ) );
        }

        return list;
    }

    @Override
    public List<ItensPedidoModel> toEntityList(List<ItensPedidoDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ItensPedidoModel> list = new ArrayList<ItensPedidoModel>( dtos.size() );
        for ( ItensPedidoDTO itensPedidoDTO : dtos ) {
            list.add( toEntity( itensPedidoDTO ) );
        }

        return list;
    }
}
