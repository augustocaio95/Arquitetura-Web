package com.example.atividade3.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProjetoDTO {
    private Integer id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<FuncionarioDTO> funcionarios;

}
