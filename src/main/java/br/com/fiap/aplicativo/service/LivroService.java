package br.com.fiap.aplicativo.service;
import br.com.fiap.aplicativo.dto.LivroDTO;
import br.com.fiap.aplicativo.dto.NovoPrecoDTO;
import br.com.fiap.aplicativo.dto.NovoLivroDTO;
import java.util.List;

public interface LivroService {

    List<LivroDTO> buscarLivros(String titulo);
    LivroDTO buscarPorId(int id);
    LivroDTO criar(NovoLivroDTO createUpdateLivroDTO);
    LivroDTO atualizar(NovoLivroDTO stockCreateUpdateDTO, int id);
    LivroDTO atualizarPreco(NovoPrecoDTO updatePrecoLivroDTO, int id);
    void delete(int id);

}