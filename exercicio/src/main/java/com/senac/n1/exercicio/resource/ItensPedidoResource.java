package com.senac.n1.exercicio.resource;

import com.senac.n1.exercicio.dto.ItensPedidoDTO;
import com.senac.n1.exercicio.interfaces.IResource;
import com.senac.n1.exercicio.service.ItensPedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/itens")
@Tag(name = "ItensPedido API", description = "API para gerenciamento de itens do pedido")
public class ItensPedidoResource implements IResource<ItensPedidoDTO, Integer> {

    @Autowired
    ItensPedidoService itensPedidoService;

    /**
     * Método para criar um novo item do pedido
     *
     * @param entity DTO do item do pedido a ser criado
     * @return DTO do item do pedido criado
     */
    @Override
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(summary = "Criação de um novo item do pedido", description = "Endpoint para criação de itens de pedido", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item do pedido criado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao criar o item do pedido")
    })
    public ItensPedidoDTO create(@RequestBody ItensPedidoDTO entity) {
        log.info("ItensPedidoResource::create");
        log.debug("Valores: {}", entity);
        return itensPedidoService.create(entity);
    }

    /**
     * Método para buscar um item do pedido baseado no ID informado
     *
     * @param id ID do item do pedido
     * @return DTO do item do pedido
     */
    @Override
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(summary = "Busca item do pedido pelo ID", description = "Busca um item específico do pedido baseado no ID informado", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item do pedido encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Item do pedido não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar o item do pedido")
    })
    public ItensPedidoDTO get(@PathVariable Integer id) {
        log.info("ItensPedidoResource::get");
        log.debug("Valores: {}", id);
        return itensPedidoService.read(id);
    }

    /**
     * Método para buscar todos os itens do pedido
     *
     * @return Lista de DTOs dos itens do pedido
     */
    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Busca todos os itens do pedido", description = "Busca todos os itens do pedido cadastrados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Itens do pedido encontrados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar os itens do pedido")
    })
    public List<ItensPedidoDTO> get() {
        log.info("ItensPedidoResource::get");
        log.debug("Valores: sem parâmetro");
        return itensPedidoService.read();
    }

    /**
     * Método para atualizar um item do pedido com base no ID informado
     *
     * @param id ID do item do pedido a ser atualizado
     * @param entity DTO do item do pedido com as atualizações
     * @return DTO do item do pedido atualizado
     */
    @Override
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Atualiza um item do pedido", description = "Atualiza um item do pedido com base no ID informado", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item do pedido atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Item do pedido não encontrado"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar o item do pedido")
    })
    public ItensPedidoDTO update(@PathVariable Integer id, @RequestBody ItensPedidoDTO entity) {
        log.info("ItensPedidoResource::update");
        log.debug("Valores: {} e {}", id, entity);
        return itensPedidoService.update(id, entity);
    }

    /**
     * Método para deletar um item do pedido com base no ID informado
     *
     * @param id ID do item do pedido a ser deletado
     */
    @Override
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleta um item do pedido", description = "Deleta um item do pedido com base no ID informado", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item do pedido deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Item do pedido não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar o item do pedido")
    })
    public void delete(@PathVariable Integer id) {
        log.info("ItensPedidoResource::delete");
        log.debug("Valores: {}", id);
        itensPedidoService.delete(id);
    }
}
