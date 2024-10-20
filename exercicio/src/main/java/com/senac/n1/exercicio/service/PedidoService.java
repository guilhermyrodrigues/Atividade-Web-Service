package com.senac.n1.exercicio.service;

import com.senac.n1.exercicio.dto.PedidoDTO;
import com.senac.n1.exercicio.interfaces.IService;
import com.senac.n1.exercicio.mapper.PedidoMapper;
import com.senac.n1.exercicio.model.PedidoModel;
import com.senac.n1.exercicio.repository.PedidoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Serviço para gerenciamento de pedidos. Implementa as operações de
 * criação, leitura, atualização e remoção de pedidos.
 */
@Service
@Slf4j
public class PedidoService implements IService<PedidoDTO, Integer> {

    @Autowired
    public PedidoRepository pedidoRepository;

    @Autowired
    public PedidoMapper pedidoMapper;

    /**
     * Cria um novo pedido.
     *
     * @param entity DTO do pedido a ser criado
     * @return DTO do pedido criado
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public PedidoDTO create(PedidoDTO entity) {
        log.info("PedidoService::create");
        log.debug("Valores: {}", entity);
        // Implementação do método de criação
        PedidoModel pedidoModel = pedidoMapper.toEntity(entity);
        PedidoModel pedidoSalvo = pedidoRepository.save(pedidoModel);
        return pedidoMapper.toDTO(pedidoSalvo);
    }

    /**
     * Busca um pedido com base no seu identificador.
     *
     * @param id ID do pedido a ser buscado
     * @return DTO do pedido encontrado
     */
    @Override
    @Transactional(readOnly = true)
    public PedidoDTO read(Integer id) {
        log.info("PedidoService::read(id)");
        log.debug("Valores: {}", id);
        // Implementação do método de leitura por ID
        return pedidoRepository.findById(id)
                .map(pedidoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Pedido com ID " + id + " não encontrado"));

    }

    /**
     * Retorna uma lista de todos os pedidos.
     *
     * @return Lista de DTOs dos pedidos
     */
    @Override
    @Transactional(readOnly = true)
    public List<PedidoDTO> read() {
        log.info("PedidoService::read()");
        log.debug("Valores: sem parâmetros");
        // Implementação do método de leitura de todos os pedidos
        List<PedidoModel> pedidoModels = pedidoRepository.findAll();
        return pedidoMapper.toDTOList(pedidoModels);
    }

    /**
     * Atualiza um pedido com base no ID informado.
     *
     * @param id ID do pedido a ser atualizado
     * @param entity DTO do pedido com os dados atualizados
     * @return DTO do pedido atualizado
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public PedidoDTO update(Integer id, PedidoDTO entity) {
        log.info("PedidoService::update");
        log.debug("Valores: {} e {}", id, entity);
        // Implementação do método de atualização
        PedidoModel pedidoModel = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido com ID " + id + " não encontrado"));

        pedidoMapper.updateEntityFromDTO(entity, pedidoModel);
        PedidoModel pedidoAtualizado = pedidoRepository.save(pedidoModel);
        return pedidoMapper.toDTO(pedidoAtualizado);
    }

    /**
     * Deleta um pedido com base no identificador informado.
     *
     * @param id ID do pedido a ser deletado
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Integer id) {
        log.info("PedidoService::delete");
        log.debug("Valores: {}", id);
        // Implementação do método de deleção
        if (!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido com ID " + id + " não encontrado");
        }
        pedidoRepository.deleteById(id);
    }
}
