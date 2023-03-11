package br.com.livraria.livraria.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.livraria.model.Livro;
import br.com.livraria.livraria.repository.LivroRepository;
import br.com.livraria.livraria.shared.LivroCompletoDto;
import br.com.livraria.livraria.shared.LivroDto;

@Service
public class LivroServiceImpl implements LivroService{

    @Autowired
    private LivroRepository repositorio;

    @Override
    public Optional<LivroDto> obterLivroPorId(String id) {
        Optional<Livro> livro = repositorio.findById(id);

        if (livro.isPresent()){
        return Optional.of(new ModelMapper().map(livro.get(), LivroDto.class));
        }
        
        return Optional.empty();
    }

    @Override
    public void excluirPorId(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<LivroCompletoDto> obterTodos() {
        List<Livro> livros = repositorio.findAll();

    return livros.stream()
                  .map(l -> new ModelMapper().map(l, LivroCompletoDto.class))
                  .collect(Collectors.toList());
      
    }

    @Override
    public LivroCompletoDto cadastrar(LivroCompletoDto dto) {
       Livro livro = new ModelMapper().map(dto, Livro.class);
       repositorio.save(livro);
       return new ModelMapper().map(livro, LivroCompletoDto.class);
    }

    @Override
    public Optional<LivroCompletoDto> atualizarPorId(String id, LivroCompletoDto dto) { 
      Optional<Livro> retorno = repositorio.findById(id);
  
      if (retorno.isPresent()) {
        Livro livro = new ModelMapper().map(dto, Livro.class);
        livro.setId(id);
        repositorio.save(livro);
        return Optional.of(new ModelMapper().map(livro, LivroCompletoDto.class));
      } else {
        return Optional.empty();
      }
      
     
    }

}


