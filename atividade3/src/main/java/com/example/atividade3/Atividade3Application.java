package com.example.atividade3;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.atividade3.models.Funcionario;
import com.example.atividade3.models.Projeto;
import com.example.atividade3.models.Setor;
import com.example.atividade3.repositories.FuncionarioRepository;
import com.example.atividade3.repositories.ProjetoRepository;
import com.example.atividade3.repositories.SetorRepository;

@SpringBootApplication
public class Atividade3Application {

	@Bean
	CommandLineRunner initDatabase(FuncionarioRepository funcionarioRepo,
			ProjetoRepository projetoRepo,
			SetorRepository setorRepo) {
		return args -> {
			// Criando Setores
			Setor setorEngenharia = new Setor("Engenharia");
			Setor setorMarketing = new Setor("Marketing");
			Setor setorOperacional = new Setor("Operações");
			List<Setor> setores = List.of(setorEngenharia, setorMarketing, setorOperacional);
			setorRepo.saveAll(setores);
			System.out.println("Setores adicionados");

			// Criando Funcionários
			Funcionario func1 = new Funcionario("Lucas Almeida", setorEngenharia);
			Funcionario func2 = new Funcionario("Juliana Castro", setorMarketing);
			Funcionario func3 = new Funcionario("Roberto Lima", setorOperacional);
			funcionarioRepo.saveAll(List.of(func1, func2, func3));
			System.out.println("Funcionários adicionados");

			// Criando Projetos
			Projeto projetoConstrucao = new Projeto("Construção Civil", LocalDate.of(2024, 2, 20),
					LocalDate.of(2024, 12, 5));
			Projeto projetoMarketingDigital = new Projeto("Campanha Digital", LocalDate.of(2024, 3, 15),
					LocalDate.of(2024, 9, 30));
			Projeto projetoLogistica = new Projeto("Logística Eficiente", LocalDate.of(2024, 5, 10),
					LocalDate.of(2024, 11, 25));
			projetoRepo.saveAll(List.of(projetoConstrucao, projetoMarketingDigital, projetoLogistica));
			System.out.println("Projetos adicionados");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Atividade3Application.class, args);
	}
}
