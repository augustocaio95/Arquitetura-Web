package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.ac1.models.Categoria;
import com.example.ac1.models.Produto;
import com.example.ac1.repositories.CategoriaProdutoRepository;
import com.example.ac1.repositories.ProdutoRepository;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(@Autowired CategoriaProdutoRepository categoriaProdutoRepository,
			@Autowired ProdutoRepository produtoRepository) {
		return args -> {
			System.out.println("*** CRIANDO AS CATEGORIAS ***");
			Categoria c1 = categoriaProdutoRepository.salvar(new Categoria(0, "Cadeira", "moveis de madeira"));
			Categoria c2 = categoriaProdutoRepository.salvar(new Categoria(0, "Mesa", "moveis de madeira"));
			List<Categoria> categorias = categoriaProdutoRepository.obterTodos();
			categorias.forEach(System.out::println);

			System.out.println("*** CRIANDO OS PRODUTOS ***");

			Produto p1 = produtoRepository.salvar(new Produto(0L, "Cadeira Confortável", 10, c1));
			Produto p2 = produtoRepository.salvar(new Produto(0L, "Mesa de Jantar", 5, c2));

			List<Produto> produtos = produtoRepository.obterTodos();
			produtos.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}
}
