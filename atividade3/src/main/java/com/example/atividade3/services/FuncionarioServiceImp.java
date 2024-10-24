package com.example.atividade3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade3.dto.FuncionarioDTO;
import com.example.atividade3.dto.ProjetoDTO;
import com.example.atividade3.models.Funcionario;
import com.example.atividade3.models.Projeto;
import com.example.atividade3.repositories.FuncionarioRepository;

@Service
public class FuncionarioServiceImp implements FuncionarioService{
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    @Override
    public void adicionar(FuncionarioDTO funcionarioDto) {
        Funcionario funcionario = Funcionario.builder()
        .nome(funcionarioDto.getNome())
        .funcionarioSetor(funcionarioDto.getSetor())
        .build();
        funcionarioRepository.save(funcionario);
    }

    @Override
    public List<ProjetoDTO> buscarProjetosPorFuncionarioId(Integer id) {
        List<Projeto> projetos = funcionarioRepository.findProjetosByFuncionarioId(id);

        return projetos.stream().map(projeto -> ProjetoDTO.builder()
        .id(projeto.getId())
        .descricao(projeto.getDescricao())
        .dataInicio(projeto.getDataInicio())
        .dataFim(projeto.getDataFim())
        .build()).toList();
    }

    @Override
    public Funcionario buscarPorId(Integer idFuncionario) {
        return funcionarioRepository.findById(idFuncionario).orElseThrow();
    }
    
}