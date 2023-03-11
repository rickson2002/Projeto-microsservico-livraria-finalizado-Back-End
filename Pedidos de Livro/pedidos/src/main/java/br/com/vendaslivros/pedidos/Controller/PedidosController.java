package br.com.vendaslivros.pedidos.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.vendaslivros.pedidos.Service.PedidosService;
import br.com.vendaslivros.pedidos.Shared.PedidoCompletoDto;
import br.com.vendaslivros.pedidos.Shared.PedidoDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Pedidos")
public class PedidosController {

    @Autowired
    private PedidosService servico;

    @PostMapping
    public ResponseEntity<PedidoCompletoDto> cadastrarPedido(@RequestBody @Valid PedidoCompletoDto pedido)
    {
        return new ResponseEntity<>(servico.CadastrarPedido(pedido),HttpStatus.CREATED);

    }

    //Ira Buscar o seu Pedido de Livro
    @GetMapping
    public ResponseEntity<List<PedidoCompletoDto>> obterPedidos()
    {
        return new ResponseEntity<>(servico.obterPedidos(),HttpStatus.OK);
    }

    //Ira Buscar seu pedido de Livro por Id
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> obterPedidoPorId(@PathVariable String id)
    {
        Optional<PedidoDto> retorno = servico.obterPedidoPorId(id);

        if(retorno.isPresent()){
            return new ResponseEntity<>(retorno.get(),HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //Ira deletar seu pedido de Livro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPedido(@PathVariable String id)
    {
        servico.excluirPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }  

    //Atualizar o seu Pedido de Livro
    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> atualizarPedido(@PathVariable String id, @Valid PedidoDto pedido){
        Optional<PedidoDto> retorno = servico.atualizarPedidoPorId(id, pedido);

        if(retorno.isPresent()){
            return new ResponseEntity<>(retorno.get(),HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
}
