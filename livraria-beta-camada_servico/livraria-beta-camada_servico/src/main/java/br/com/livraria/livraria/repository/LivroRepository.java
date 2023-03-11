package br.com.livraria.livraria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.livraria.livraria.model.Livro;


public interface LivroRepository extends MongoRepository<Livro, String> {
    
}
