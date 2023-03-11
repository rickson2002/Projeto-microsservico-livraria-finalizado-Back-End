package br.com.livraria.livraria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.livraria.livraria.service.LivroService;
import br.com.livraria.livraria.shared.LivroCompletoDto;
import br.com.livraria.livraria.shared.LivroDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/prateleira")
public class LivroController {
@Autowired
private LivroService servico;


@PostMapping
public ResponseEntity<LivroCompletoDto> cadastrarLivro(@RequestBody @Valid LivroCompletoDto livro){
    return new ResponseEntity<>(servico.cadastrar(livro), HttpStatus.CREATED);

    }
@GetMapping
public ResponseEntity<List<LivroCompletoDto>> obterPrateleira(){
    return new ResponseEntity<>(servico.obterTodos(), HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<LivroDto> obterLivro(@PathVariable String id){
Optional<LivroDto> retorno = servico.obterLivroPorId(id);

if (retorno.isPresent()){
     return new ResponseEntity<>(retorno.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> excluirLivro(@PathVariable String id){
    servico.excluirPorId(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }    

@PutMapping("/{id}")
public ResponseEntity<LivroCompletoDto> atualizarLivro(@PathVariable String id, @RequestBody LivroCompletoDto livro){
    Optional<LivroCompletoDto> retorno =  servico.atualizarPorId(id, livro);

    if (retorno.isPresent()) {
        return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);

    } else {
    return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

     }


     @GetMapping("/porta")
     public String obterPorta(@Value("${local.server.port}")String porta){
        return "a insacia que respondeu a requisição esta rodando na porta" + porta;
     }


}
