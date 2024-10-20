package com.senac.n1.exercicio.resource;

import com.senac.n1.exercicio.dto.ProdutoDTO;
import com.senac.n1.exercicio.interfaces.IResource;
import com.senac.n1.exercicio.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "api/produtos")
@Tag(name = "Produto API", description = "API para gerenciamento de produtos")
public class ProdutoResource implements IResource<ProdutoDTO, Integer> {

    @Autowired
    ProdutoService produtoService;

    /**
     * Método para criar um novo produto
     *
     * @param entity DTO do produto a ser criado
     * @return DTO do produto criado
     */
    @Override
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(summary = "Criação de um novo produto", description = "Endpoint para criação de produtos", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto criado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao criar o produto")
    })
    public ProdutoDTO create(@RequestBody ProdutoDTO entity) {
        log.info("ProdutoResource::create");
        log.debug("Valores: {}", entity);
        return produtoService.create(entity);
    }

    /**
     * Método para buscar um produto baseado no ID informado
     *
     * @param id ID do produto
     * @return DTO do produto encontrado
     */
    @Override
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(summary = "Busca produto pelo ID", description = "Busca um produto específico baseado no ID informado", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar o produto")
    })
    public ProdutoDTO get(@PathVariable Integer id) {
        log.info("ProdutoResource::get");
        log.debug("Valores: {}", id);
        return produtoService.read(id);
    }

    /**
     * Método para buscar todos os produtos
     *
     * @return Lista de DTOs dos produtos
     */
    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Busca todos os produtos", description = "Busca todos os produtos cadastrados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produtos encontrados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar os produtos")
    })
    public List<ProdutoDTO> get() {
        log.info("ProdutoResource::get");
        log.debug("Valores: sem parâmetro");
        return produtoService.read();
    }

    /**
     * Método para atualizar um produto com base no ID informado
     *
     * @param id ID do produto a ser atualizado
     * @param entity DTO do produto com as atualizações
     * @return DTO do produto atualizado
     */
    @Override
    @PutMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(summary = "Atualiza um produto", description = "Atualiza um produto com base no ID informado", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar o produto")
    })
    public ProdutoDTO update(@PathVariable Integer id, @RequestBody ProdutoDTO entity) {
        log.info("ProdutoResource::update");
        log.debug("Valores: {} e {}", id, entity);
        return produtoService.update(id, entity);
    }

    /**
     * Método para deletar um produto com base no ID informado
     *
     * @param id ID do produto a ser deletado
     */
    @Override
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleta um produto", description = "Deleta um produto com base no ID informado", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar o produto")
    })
    public void delete(@PathVariable Integer id) {
        log.info("ProdutoResource::delete");
        log.debug("Valores: {}", id);
        produtoService.delete(id);
    }
}
