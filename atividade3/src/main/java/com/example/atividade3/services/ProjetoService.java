package com.example.atividade3.services;

import java.time.LocalDate;
import java.util.List;

import com.example.atividade3.dto.ProjetoDTO;

public interface ProjetoService {
    void adicionarProjeto(ProjetoDTO projeto);
    void vincularFuncionario(Integer projetoId, Integer funcionarioId);
    ProjetoDTO buscarProjetoPorId(Integer id);
    List<ProjetoDTO> buscarProjetosPorPeriodo(LocalDate dataInicio, LocalDate dataFim);
}
