package com.senac.n1.exercicio.repository;

import com.senac.n1.exercicio.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Integer> {
}
