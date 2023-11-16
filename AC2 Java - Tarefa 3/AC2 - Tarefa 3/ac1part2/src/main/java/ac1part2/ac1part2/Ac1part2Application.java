package ac1part2.ac1part2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ac1part2.ac1part2.Entities.Categoria;
import ac1part2.ac1part2.Entities.Produto;
import ac1part2.ac1part2.Repositories.CategoriaRepository;
import ac1part2.ac1part2.Repositories.ProdutoRepository;

@SpringBootApplication
public class Ac1part2Application implements CommandLineRunner {

@Autowired
private CategoriaRepository categoriaRepository;

@Autowired
private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Ac1part2Application.class, args);
	}

@Override
public void run(String... args) throws Exception{

   Categoria c1 = new Categoria();
   c1.setNome("Eletrônicos");

   Categoria c2 = new Categoria();
   c2.setNome("Roupas");

   categoriaRepository.save(c1);
   categoriaRepository.save(c2);


    Produto p1 = new Produto();
	p1.setNome("Camisetas");
	p1.setPreço(60.00);

	Produto p2 = new Produto();
	p2.setNome("videogame");
	p2.setPreço(4199.00);

    produtoRepository.save(p1);
	produtoRepository.save(p2);


    //CategoriaRepository
    
	List<Categoria> procurarpornome = categoriaRepository.findpornomeque("E");
	System.out.println("Categoria começando com 'E':  ");
	for (Categoria categoria : procurarpornome) {
	System.out.println(categoria.getNome());
	}
    
	Categoria categoriaprodutos = categoriaRepository.findbyidcomprodutos(1L);
	System.out.println("Categoria com ID 1 + produtos: ");
	System.out.println("Categoria: " + categoriaprodutos.getNome());
	System.out.println("Produtos: ");
	for (Produto produto : categoriaprodutos.getProdutos()){
		System.out.println(produto.getNome());
	}


    //ProdutoRepository 

	List<Produto> produtosmaiorque = produtoRepository.findporPrecomaiorque(3000.00);
	System.out.println("Produtos maior que 3000.00: ");
	produtosmaiorque.forEach(produto -> System.out.println(produto.getNome()));

    List<Produto> produtosmenorque = produtoRepository.findporprecomenosquouigual(4199.00);
	System.out.println("\n Produtos menor ou igual que 4199.00: ");
	produtosmenorque.forEach(produto -> System.out.println(produto.getNome()));
    
	List<Produto> produtoscomeçandocom = produtoRepository.findpornomecomeçandocom("Videogame");
	System.out.println("\n Produtos começando com Video game");
	produtoscomeçandocom.forEach(produto -> System.out.println(produto.getNome()));
}

}
