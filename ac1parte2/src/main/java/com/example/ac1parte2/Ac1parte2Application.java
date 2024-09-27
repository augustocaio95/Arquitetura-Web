package com.example.ac1parte2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1parte2.models.Categoria;
import com.example.ac1parte2.models.Produto;
import com.example.ac1parte2.respositories.CategoriaRepository;
import com.example.ac1parte2.respositories.ProdutoRepository;


@SpringBootApplication
public class Ac1parte2Application {
	
	 
	 @Bean
	 public CommandLineRunner init(
			 @Autowired ProdutoRepository produtoRepository,
			 @Autowired CategoriaRepository categoriaRepository) {
		 return args -> {
			 System.out.println("*** CRIANDO AS CATEGORIAS ***");
			 Categoria categoria1 = new Categoria(null, "Eletrônicos", null);
			 Categoria categoria2 = new Categoria(null, "Vestuário", null);
			 categoria1 = categoriaRepository.save(categoria1);
			 categoria2 = categoriaRepository.save(categoria2);
	 
			 System.out.println("*** CRIANDO OS PRODUTOS ***");
			 Produto produto1 = new Produto(null, "Smartphone", 1500.0, categoria1);
			 Produto produto2 = new Produto(null, "Camisa", 50.0, categoria2);
			 Produto produto3 = new Produto(null, "Laptop", 3500.0, categoria1);
			 produtoRepository.save(produto1);
			 produtoRepository.save(produto2);
			 produtoRepository.save(produto3);
	 
			 System.out.println("*** TODOS OS PRODUTOS ***");
			 List<Produto> todosProdutos = produtoRepository.findAll();
			 todosProdutos.forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco()));
	 
			 System.out.println("*** PRODUTOS COM PREÇO MAIOR QUE 1000 ***");
			 List<Produto> produtosCaros = produtoRepository.findByPrecoGreaterThan(1000.0);
			 produtosCaros.forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco()));
	 
			 System.out.println("*** PRODUTOS COM PREÇO MENOR OU IGUAL A 1000 ***");
			 List<Produto> produtosBaratos = produtoRepository.findByPrecoLessThanEqual(1000.0);
			 produtosBaratos.forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco()));
	 
			 System.out.println("*** PRODUTOS QUE COMEÇAM COM 'S' ***");
			List<Produto> produtosNomeS = produtoRepository.findByNomeStartingWith("S");
			 produtosNomeS.forEach(p -> System.out.println(p.getNome()));
			 
			 
			System.out.println("*** CATEGORIAS QUE COMEÇAM COM 'E' ***");
			List<Categoria> categoriasComE = categoriaRepository.findByNomeStartingWith("E");
			categoriasComE.forEach(c -> System.out.println(c.getNome()));

			
			System.out.println("*** LISTANDO PRODUTOS DA CATEGORIA COM ID 1 ***");
			Categoria categoriaComProdutos = categoriaRepository.findByIdWithProdutos(1L);
			System.out.println("Categoria: " + categoriaComProdutos.getNome());
			categoriaComProdutos.getProdutos().forEach(p -> System.out.println("Produto: " + p.getNome()));
		};



		 };
	 
	 
	public static void main(String[] args) {
		SpringApplication.run(Ac1parte2Application.class, args);
	}

}
