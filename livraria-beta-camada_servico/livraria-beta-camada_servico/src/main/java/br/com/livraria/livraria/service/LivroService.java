package br.com.livraria.livraria.service;

import java.util.List;
import java.util.Optional;

import br.com.livraria.livraria.shared.LivroCompletoDto;
import br.com.livraria.livraria.shared.LivroDto;


public interface LivroService {
    List<LivroCompletoDto> obterTodos();
    Optional<LivroDto> obterLivroPorId(String id);
    void excluirPorId(String id);
    LivroCompletoDto cadastrar(LivroCompletoDto dto);
    Optional<LivroCompletoDto> atualizarPorId(String id, LivroCompletoDto dto); 
}
