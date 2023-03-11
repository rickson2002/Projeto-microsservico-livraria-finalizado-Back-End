package br.com.vendaslivros.pedidos.HttpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.vendaslivros.pedidos.Model.Livro;

@FeignClient("livraria")
public interface LivrariaClient {

  @RequestMapping(method= RequestMethod.GET, value="/prateleira/{id}")
  Livro obterLivro(@PathVariable String id);
  
}
