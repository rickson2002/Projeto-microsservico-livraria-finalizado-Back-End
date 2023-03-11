package br.com.vendaslivros.pedidos.Service;

import java.util.List;
import java.util.Optional;

import br.com.vendaslivros.pedidos.Shared.PedidoCompletoDto;
import br.com.vendaslivros.pedidos.Shared.PedidoDto;

public interface PedidosService {

    List<PedidoCompletoDto> obterPedidos();
    Optional<PedidoDto> obterPedidoPorId(String id);
    void excluirPedido(String id);
    PedidoCompletoDto CadastrarPedido(PedidoCompletoDto pedido);
    Optional<PedidoDto> atualizarPedidoPorId(String id, PedidoDto dto);
    


    
}
