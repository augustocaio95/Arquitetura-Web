package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Categoria salvar(Categoria categoria) {
        categoria = entityManager.merge(categoria); 
        return categoria;
    }

    public List<Categoria> obterTodos() {
        return entityManager
                .createQuery("SELECT c FROM Categoria c", Categoria.class)
                .getResultList(); 
    }

    public Categoria obterPorId(Long id) {
        return entityManager.find(Categoria.class, id); 
    }

    @Transactional
    public void excluir(Long id) {
        Categoria categoria = obterPorId(id);
        if (categoria != null) {
            entityManager.remove(categoria); 
        }
    }
}
