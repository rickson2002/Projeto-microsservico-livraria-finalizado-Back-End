package br.com.vendaslivros.pedidos.Shared;

import br.com.vendaslivros.pedidos.Model.Livro;

public class PedidoDto {
    private String nomeCliente;
    private String idLivro;
    private Livro dadosDoLivro;
    private Double valor;
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getIdLivro() {
        return idLivro;
    }
    public void setIdLivro(String idLivro) {
        this.idLivro = idLivro;
    }
    public Livro getDadosDoLivro() {
        return dadosDoLivro;
    }
    public void setDadosDoLivro(Livro dadosDoLivro) {
        this.dadosDoLivro = dadosDoLivro;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    

}
