package com.senac.n1.exercicio.repository;

import com.senac.n1.exercicio.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {
}
