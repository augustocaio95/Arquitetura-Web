package com.example.ac1parte2.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import com.example.ac1parte2.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    
 List<Produto> findByPrecoGreaterThan(Double preco);
 List<Produto> findByPrecoLessThanEqual(Double preco);
 List<Produto> findByNomeStartingWith(String prefixo);
    
    
}
