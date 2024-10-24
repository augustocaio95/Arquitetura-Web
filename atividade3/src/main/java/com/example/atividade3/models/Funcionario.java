package com.example.atividade3.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "funcionarioSetor_id")
    private Setor funcionarioSetor;

   
        @ManyToMany(mappedBy = "funcionarios")
    private List<Projeto> projetos;

    public Funcionario(String nome, Setor funcionarioSetor) {
        this.nome = nome;
        this.funcionarioSetor = funcionarioSetor;
    }

    public Funcionario(String nome) {
        this.nome = nome;
    }
}
