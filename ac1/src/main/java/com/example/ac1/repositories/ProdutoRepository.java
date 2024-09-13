package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto salvar(Produto produto) {
        produto = entityManager.merge(produto); 
        return produto;
    }

    public List<Produto> obterTodos() {
        return entityManager
                .createQuery("SELECT p FROM Produto p", Produto.class)
                .getResultList(); 
    }

    public Produto obterPorId(Long id) {
        return entityManager.find(Produto.class, id); 
    }

    @Transactional
    public void excluir(Long id) {
        Produto produto = obterPorId(id);
        if (produto != null) {
            entityManager.remove(produto); 
        }
    }
}

