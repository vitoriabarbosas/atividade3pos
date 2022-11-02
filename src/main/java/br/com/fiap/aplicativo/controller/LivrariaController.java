package br.com.fiap.aplicativo.controller;
import br.com.fiap.aplicativo.dto.LivroDTO;
import br.com.fiap.aplicativo.dto.NovoLivroDTO;
import br.com.fiap.aplicativo.dto.NovoPrecoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("livros")
public class LivrariaController {
    @GetMapping("{id}")
    public LivroDTO buscarPorId(@PathVariable int id) {
        List<LivroDTO> livroDTOList = new ArrayList<>();
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(1);
        livroDTO.setTitulo("Aprenda Spring");
        livroDTO.setDescricao("Passo a passo com Spring Framework");
        livroDTO.setDataDePublicacao(new Date());
        livroDTO.setISBN("938472389472393482");
        livroDTO.setPreco(20.4);
        livroDTOList.add(livroDTO);
        LivroDTO livroDTO1 = new LivroDTO();
        livroDTO1.setId(2);
        livroDTO1.setTitulo("Java");
        livroDTO1.setDescricao("Tudo sobre Java");
        livroDTO1.setDataDePublicacao(new Date());
        livroDTO1.setISBN("9548675464588");
        livroDTO1.setPreco(15.3);
        livroDTOList.add(livroDTO1);
        switch(id) {
            case 1:
                return livroDTO;
            case 2:
                return livroDTO1;
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Livro não encontrado");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroDTO criar(@RequestBody NovoLivroDTO novoLivroDTO){
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(3);
        livroDTO.setTitulo(novoLivroDTO.getTitulo());
        livroDTO.setDescricao(novoLivroDTO.getDescricao());
        livroDTO.setISBN(novoLivroDTO.getISBN());
        livroDTO.setPreco(novoLivroDTO.getPreco());
        livroDTO.setDataDePublicacao(novoLivroDTO.getDataDePublicacao());
        return livroDTO;
    }

    @PutMapping("{id}")
    public LivroDTO atualizar(
            @PathVariable int id,
            @RequestBody NovoLivroDTO novoLivroDTO
    ){
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(id);
        livroDTO.setTitulo(novoLivroDTO.getTitulo());
        livroDTO.setDescricao(novoLivroDTO.getDescricao());
        livroDTO.setISBN(novoLivroDTO.getISBN());
        livroDTO.setPreco(novoLivroDTO.getPreco());
        livroDTO.setDataDePublicacao(novoLivroDTO.getDataDePublicacao());
        return livroDTO;
    }

    @PatchMapping("{id}/preco")
    public LivroDTO atualizarPreco(
            @PathVariable int id,
            @RequestBody NovoPrecoDTO novoPrecoDTO
    ){
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(id);
        livroDTO.setPreco(novoPrecoDTO.getPreco());
        return livroDTO;
    }
}



