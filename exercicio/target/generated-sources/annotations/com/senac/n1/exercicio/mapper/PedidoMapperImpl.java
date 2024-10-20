package com.senac.n1.exercicio.mapper;

import com.senac.n1.exercicio.dto.PedidoDTO;
import com.senac.n1.exercicio.model.PedidoModel;
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
public class PedidoMapperImpl implements PedidoMapper {

    @Override
    public PedidoModel toEntity(PedidoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PedidoModel pedidoModel = new PedidoModel();

        pedidoModel.setId( dto.getId() );
        pedidoModel.setNroPedido( dto.getNroPedido() );
        pedidoModel.setDatPedido( dto.getDatPedido() );

        return pedidoModel;
    }

    @Override
    public PedidoDTO toDTO(PedidoModel entity) {
        if ( entity == null ) {
            return null;
        }

        PedidoDTO pedidoDTO = new PedidoDTO();

        pedidoDTO.setId( entity.getId() );
        pedidoDTO.setNroPedido( entity.getNroPedido() );
        pedidoDTO.setDatPedido( entity.getDatPedido() );

        return pedidoDTO;
    }

    @Override
    public void updateEntityFromDTO(PedidoDTO dto, PedidoModel entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        entity.setNroPedido( dto.getNroPedido() );
        entity.setDatPedido( dto.getDatPedido() );
    }

    @Override
    public List<PedidoDTO> toDTOList(List<PedidoModel> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PedidoDTO> list = new ArrayList<PedidoDTO>( entities.size() );
        for ( PedidoModel pedidoModel : entities ) {
            list.add( toDTO( pedidoModel ) );
        }

        return list;
    }

    @Override
    public List<PedidoModel> toEntityList(List<PedidoDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<PedidoModel> list = new ArrayList<PedidoModel>( dtos.size() );
        for ( PedidoDTO pedidoDTO : dtos ) {
            list.add( toEntity( pedidoDTO ) );
        }

        return list;
    }
}
