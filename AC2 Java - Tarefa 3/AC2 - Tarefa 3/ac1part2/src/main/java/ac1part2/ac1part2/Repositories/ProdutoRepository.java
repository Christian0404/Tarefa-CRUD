package ac1part2.ac1part2.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ac1part2.ac1part2.Entities.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {
 List<Produto> findporPrecomaiorque (Double valor);

 List<Produto> findporprecomenosquouigual (Double valor);

 List<Produto> findpornomecomeçandocom (String nome);

}
