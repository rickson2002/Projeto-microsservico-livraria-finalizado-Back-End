package br.com.livraria.livraria.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Livros")
public class Livro {
    
    @Id
    private String id;
    private String nome;
    private String autor;
    private List<String> generoDoLivro;
    private String anoDeLancamento;
    private Double valorDoLivro;
    private Double numeroDePag;
    
    public Double getNumeroDePag() {
        return numeroDePag;
    }
    public void setNumeroDePag(Double numeroDePag) {
        this.numeroDePag = numeroDePag;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public List<String> getGeneroDoLivro() {
        return generoDoLivro;
    }
    public void setGeneroDoLivro(List<String> generoDoLivro) {
        this.generoDoLivro = generoDoLivro;
    }
    public Double getValorDoLivro() {
        return valorDoLivro;
    }
    public void setValorDoLivro(Double valorDoLivro) {
        this.valorDoLivro = valorDoLivro;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAnoDeLancamento() {
        return anoDeLancamento;
    }
    public void setAnoDeLancamento(String anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }
 
}
