package com.senac.n1.exercicio.service;

import com.senac.n1.exercicio.dto.ItensPedidoDTO;
import com.senac.n1.exercicio.interfaces.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Serviço para gerenciamento de itens do pedido. Implementa as operações de
 * criação, leitura, atualização e remoção de itens de um pedido.
 */
@Service
@Slf4j
public class ItensPedidoService implements IService<ItensPedidoDTO, Integer> {

    /**
     * Cria um novo item no pedido.
     *
     * @param entity DTO do item de pedido a ser criado
     * @return DTO do item de pedido criado
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ItensPedidoDTO create(ItensPedidoDTO entity) {
        log.info("ItensPedidoService::create");
        log.debug("Valores: {}", entity);
        // Implementação do método de criação
        return null;
    }

    /**
     * Busca um item de pedido com base no seu identificador.
     *
     * @param id ID do item de pedido a ser buscado
     * @return DTO do item de pedido encontrado
     */
    @Override
    @Transactional(readOnly = true)
    public ItensPedidoDTO read(Integer id) {
        log.info("ItensPedidoService::read(id)");
        log.debug("Valores: {}", id);
        // Implementação do método de leitura por ID
        return null;
    }

    /**
     * Retorna uma lista de todos os itens de pedido.
     *
     * @return Lista de DTOs dos itens de pedido
     */
    @Override
    @Transactional(readOnly = true)
    public List<ItensPedidoDTO> read() {
        log.info("ItensPedidoService::read()");
        log.debug("Valores: sem parâmetros");
        // Implementação do método de leitura de todos os itens
        return List.of();
    }

    /**
     * Atualiza um item de pedido com base no ID informado.
     *
     * @param id ID do item de pedido a ser atualizado
     * @param entity DTO do item de pedido com os dados atualizados
     * @return DTO do item de pedido atualizado
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ItensPedidoDTO update(Integer id, ItensPedidoDTO entity) {
        log.info("ItensPedidoService::update");
        log.debug("Valores: {} e {}", id, entity);
        // Implementação do método de atualização
        return null;
    }

    /**
     * Deleta um item de pedido com base no identificador informado.
     *
     * @param id ID do item de pedido a ser deletado
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Integer id) {
        log.info("ItensPedidoService::delete");
        log.debug("Valores: {}", id);
        // Implementação do método de deleção
    }
}
