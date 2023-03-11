package br.com.vendaslivros.pedidos.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vendaslivros.pedidos.HttpClient.LivrariaClient;
import br.com.vendaslivros.pedidos.Model.Pedidos;
import br.com.vendaslivros.pedidos.Repository.PedidoRepository;
import br.com.vendaslivros.pedidos.Shared.PedidoCompletoDto;
import br.com.vendaslivros.pedidos.Shared.PedidoDto;

@Service
public class PedidoServiceImp implements PedidosService {
    
    @Autowired
    private PedidoRepository repository;

    @Autowired
    private LivrariaClient livrariaClient;

    @Override
    public List<PedidoCompletoDto> obterPedidos(){
        List<Pedidos> pedido = repository.findAll();
        List<PedidoCompletoDto> dto = pedido.stream().map(p -> new ModelMapper().map(p, PedidoCompletoDto.class)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public void excluirPedido(String id) {
        repository.deleteById(id);

    }

    @Override
    public PedidoCompletoDto CadastrarPedido(PedidoCompletoDto dto) {
        Pedidos pedido = new ModelMapper().map(dto, Pedidos.class);

        repository.save(pedido);
        return new ModelMapper().map(pedido,PedidoCompletoDto.class);

    }

    @Override
    public Optional<PedidoDto> atualizarPedidoPorId(String id, PedidoDto dto) {
        Optional<Pedidos> retorno = repository.findById(id);

        if(retorno.isPresent()){
            Pedidos pedidoRetorno = new ModelMapper().map(dto, Pedidos.class);
            pedidoRetorno.setId(id);
            repository.save(pedidoRetorno);
            return Optional.of(new ModelMapper().map(pedidoRetorno, PedidoDto.class));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<PedidoDto> obterPedidoPorId(String id) {

        Optional<Pedidos> pedido = repository.findById(id);
        if(pedido.isPresent()){
            PedidoDto pedidoComLivro = new ModelMapper().map(pedido, PedidoDto.class);
            pedidoComLivro.setDadosDoLivro(livrariaClient.obterLivro(pedidoComLivro.getIdLivro()));
            return Optional.of(pedidoComLivro);
        }else{
            return Optional.empty();
        }
       
    }

}
