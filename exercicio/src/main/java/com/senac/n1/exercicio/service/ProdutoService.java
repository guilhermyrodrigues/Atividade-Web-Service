package com.senac.n1.exercicio.service;

import com.senac.n1.exercicio.dto.ProdutoDTO;
import com.senac.n1.exercicio.interfaces.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Serviço para gerenciamento de produtos. Implementa as operações de
 * criação, leitura, atualização e remoção de produtos.
 */
@Service
@Slf4j
public class ProdutoService implements IService<ProdutoDTO, Integer> {

    /**
     * Cria um novo produto.
     *
     * @param entity DTO do produto a ser criado
     * @return DTO do produto criado
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ProdutoDTO create(ProdutoDTO entity) {
        log.info("ProdutoService::create");
        log.debug("Valores: {}", entity);
        // Implementação do método de criação
        return null;
    }

    /**
     * Busca um produto com base no seu identificador.
     *
     * @param id ID do produto a ser buscado
     * @return DTO do produto encontrado
     */
    @Override
    @Transactional(readOnly = true)
    public ProdutoDTO read(Integer id) {
        log.info("ProdutoService::read(id)");
        log.debug("Valores: {}", id);
        // Implementação do método de leitura por ID
        return null;
    }

    /**
     * Retorna uma lista de todos os produtos.
     *
     * @return Lista de DTOs dos produtos
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProdutoDTO> read() {
        log.info("ProdutoService::read()");
        log.debug("Valores: sem parâmetros");
        // Implementação do método de leitura de todos os produtos
        return List.of();
    }

    /**
     * Atualiza um produto com base no ID informado.
     *
     * @param id ID do produto a ser atualizado
     * @param entity DTO do produto com os dados atualizados
     * @return DTO do produto atualizado
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ProdutoDTO update(Integer id, ProdutoDTO entity) {
        log.info("ProdutoService::update");
        log.debug("Valores: {} e {}", id, entity);
        // Implementação do método de atualização
        return null;
    }

    /**
     * Deleta um produto com base no identificador informado.
     *
     * @param id ID do produto a ser deletado
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Integer id) {
        log.info("ProdutoService::delete");
        log.debug("Valores: {}", id);
        // Implementação do método de deleção
    }
}
