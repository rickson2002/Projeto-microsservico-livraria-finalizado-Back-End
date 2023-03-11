package br.com.vendaslivros.pedidos.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("pedidos")
public class Pedidos {
    @Id
    private String id;
    private String nomeCliente;
    private String idLivro;
    private Double valor;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public String getIdLivro() {
        return idLivro;
    }
    public void setIdLivro(String idLivro) {
        this.idLivro = idLivro;
    }



    
}
