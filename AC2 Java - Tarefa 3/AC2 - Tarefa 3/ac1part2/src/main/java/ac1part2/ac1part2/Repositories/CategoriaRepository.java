package ac1part2.ac1part2.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ac1part2.ac1part2.Entities.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {

    List<Categoria> findpornomeque (String nome);

    @Query
    Categoria findbyidcomprodutos (Long id);
    
}
