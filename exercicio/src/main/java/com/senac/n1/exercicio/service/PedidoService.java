package com.senac.n1.exercicio.service;

import com.senac.n1.exercicio.dto.PedidoDTO;
import com.senac.n1.exercicio.interfaces.IService;
import lombok.extern.slf4j.Slf4j;
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
        return null;
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
        return null;
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
        return List.of();
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
        return null;
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
    }
}
