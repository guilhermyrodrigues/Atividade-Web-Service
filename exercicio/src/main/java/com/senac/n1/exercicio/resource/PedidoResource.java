package com.senac.n1.exercicio.resource;

import com.senac.n1.exercicio.dto.PedidoDTO;
import com.senac.n1.exercicio.interfaces.IResource;
import com.senac.n1.exercicio.service.PedidoService;
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
@RequestMapping(value = "api/pedidos")
@Tag(name = "Pedido API", description = "API para gerenciamento de pedidos")
public class PedidoResource implements IResource<PedidoDTO, Integer> {

    @Autowired
    PedidoService pedidoService;

    /**
     * Método para criar um novo pedido
     *
     * @param entity DTO do pedido a ser criado
     * @return DTO do pedido criado
     */
    @Override
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(summary = "Criação de um novo pedido", description = "Endpoint para criação de pedidos", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido criado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao criar o pedido")
    })
    public PedidoDTO create(@RequestBody PedidoDTO entity) {
        log.info("PedidoResource::create");
        log.debug("Valores: {}", entity);
        return pedidoService.create(entity);
    }

    /**
     * Método para buscar um pedido baseado no ID informado
     *
     * @param id ID do pedido
     * @return DTO do pedido encontrado
     */
    @Override
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(summary = "Busca pedido pelo ID", description = "Busca um pedido específico baseado no ID informado", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar o pedido")
    })
    public PedidoDTO get(@PathVariable Integer id) {
        log.info("PedidoResource::get");
        log.debug("Valores: {}", id);
        return pedidoService.read(id);
    }

    /**
     * Método para buscar todos os pedidos
     *
     * @return Lista de DTOs dos pedidos
     */
    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Busca todos os pedidos", description = "Busca todos os pedidos cadastrados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedidos encontrados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar os pedidos")
    })
    public List<PedidoDTO> get() {
        log.info("PedidoResource::get");
        log.debug("Valores: sem parâmetro");
        return pedidoService.read();
    }

    /**
     * Método para atualizar um pedido com base no ID informado
     *
     * @param id ID do pedido a ser atualizado
     * @param entity DTO do pedido com as atualizações
     * @return DTO do pedido atualizado
     */
    @Override
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Atualiza um pedido", description = "Atualiza um pedido com base no ID informado", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar o pedido")
    })
    public PedidoDTO update(@PathVariable Integer id, @RequestBody PedidoDTO entity) {
        log.info("PedidoResource::update");
        log.debug("Valores: {} e {}", id, entity);
        return pedidoService.update(id, entity);
    }

    /**
     * Método para deletar um pedido com base no ID informado
     *
     * @param id ID do pedido a ser deletado
     */
    @Override
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleta um pedido", description = "Deleta um pedido com base no ID informado", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar o pedido")
    })
    public void delete(@PathVariable Integer id) {
        log.info("PedidoResource::delete");
        log.debug("Valores: {}", id);
        pedidoService.delete(id);
    }
}
