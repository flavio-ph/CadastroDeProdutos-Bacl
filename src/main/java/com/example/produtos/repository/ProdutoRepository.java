package com.example.produtos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.produtos.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
