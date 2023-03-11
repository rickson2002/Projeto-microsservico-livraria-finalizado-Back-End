package br.com.livraria.livraria.shared;

public class LivroDto {
    private String id;
    private String nome;
    private String autor;
    private Double valorDoLivro;
    private Double numeroDePag;
    private String anoDeLancamento;
    


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public Double getValorDoLivro() {
        return valorDoLivro;
    }
    public void setValorDoLivro(Double valorDoLivro) {
        this.valorDoLivro = valorDoLivro;
    }
    public Double getNumeroDePag() {
        return numeroDePag;
    }
    public void setNumeroDePag(Double numeroDePag) {
        this.numeroDePag = numeroDePag;
    }
    public String getAnoDeLancamento() {
        return anoDeLancamento;
    }
    public void setAnoDeLancamento(String anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }


    
}
