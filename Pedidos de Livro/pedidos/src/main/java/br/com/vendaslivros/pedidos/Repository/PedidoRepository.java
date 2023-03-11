package br.com.vendaslivros.pedidos.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.vendaslivros.pedidos.Model.Pedidos;

public interface PedidoRepository extends MongoRepository<Pedidos,String> {
    
}
