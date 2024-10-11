package com.senac.n1.exercicio.repository;

import com.senac.n1.exercicio.model.ItensPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidoRepository extends JpaRepository<ItensPedidoModel, Integer> {
}
