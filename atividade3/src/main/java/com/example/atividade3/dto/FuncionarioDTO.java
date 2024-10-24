package com.example.atividade3.dto;

import com.example.atividade3.models.Setor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FuncionarioDTO {
    private Integer id;
    private String nome;
    private Integer setorId;
    private String setorNome;
    private Setor setor;
}
