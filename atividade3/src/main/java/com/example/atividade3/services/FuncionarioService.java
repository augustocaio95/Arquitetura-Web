package com.example.atividade3.services;

import java.util.List;

import com.example.atividade3.dto.FuncionarioDTO;
import com.example.atividade3.dto.ProjetoDTO;
import com.example.atividade3.models.Funcionario;

public interface FuncionarioService {
    void adicionar(FuncionarioDTO funcionario);
    List<ProjetoDTO> buscarProjetosPorFuncionarioId(Integer idFuncionario);

    Funcionario buscarPorId(Integer idFuncionario);

}
