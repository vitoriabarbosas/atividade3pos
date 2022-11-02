package br.com.fiap.aplicativo.reposity;
import br.com.fiap.aplicativo.entity.Livro;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro,Integer>{
        List<Livro> findAllByTituloLike(String titulo);

       @Query("from Livro l " +
                "where l.titulo like %:titulo%")
        List<Livro> buscaPorTitulo(String titulo);

}
