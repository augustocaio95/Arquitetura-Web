package com.example.atividade3.services;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade3.dto.FuncionarioDTO;
import com.example.atividade3.dto.ProjetoDTO;
import com.example.atividade3.models.Funcionario;
import com.example.atividade3.models.Projeto;
import com.example.atividade3.repositories.FuncionarioRepository;
import com.example.atividade3.repositories.ProjetoRepository;
import com.example.atividade3.repositories.SetorRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@Setter
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ProjetoServiceImp implements ProjetoService{

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private SetorRepository setorRepository;
    @Override
    public void adicionarProjeto(ProjetoDTO projetoDto) {
        Projeto projeto = Projeto.builder()
        .descricao(projetoDto.getDescricao())
        .dataInicio(projetoDto.getDataInicio())
        .dataFim(projetoDto.getDataFim())
        .build();

        projetoRepository.save(projeto);
    }

    @Override
    public void vincularFuncionario(Integer projetoId, Integer funcionarioId) {
        Projeto projeto = projetoRepository.findById(projetoId).orElseThrow();
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow();

        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
        funcionarioRepository.save(funcionario);
    }

    @Override
    public ProjetoDTO buscarProjetoPorId(Integer id) {
        Projeto projeto = projetoRepository.findById(id).orElseThrow();

        return ProjetoDTO.builder()
            .descricao(projeto.getDescricao())
            .dataInicio(projeto.getDataInicio())
            .dataFim(projeto.getDataFim())
            .funcionarios(projeto.getFuncionarios().stream()
            .map(funcionario -> FuncionarioDTO.builder()
                .id(funcionario.getId())
                .nome(funcionario.getNome())
                .build())
                .collect(Collectors.toList()))
            .build();
    }

    @Override
    public List<ProjetoDTO> buscarProjetosPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {

        List<Projeto> projetos = projetoRepository.findProjetosByDataInicioBetween(dataInicio, dataFim);

        return projetos.stream().map((Projeto p) -> {


            return ProjetoDTO.builder()
            .id(p.getId())
            .descricao(p.getDescricao())
            .dataInicio(p.getDataInicio())
            .dataFim(p.getDataFim())
            .funcionarios(p.getFuncionarios().stream()
            .map(funcionario -> FuncionarioDTO.builder()
                .id(funcionario.getId())
                .nome(funcionario.getNome())
                .build())
                .collect(Collectors.toList()))
            .build();
        }).collect(Collectors.toList());
    }
    
}
