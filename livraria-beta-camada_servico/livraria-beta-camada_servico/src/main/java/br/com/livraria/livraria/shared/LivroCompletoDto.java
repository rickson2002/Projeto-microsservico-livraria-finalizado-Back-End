package br.com.livraria.livraria.shared;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class LivroCompletoDto {
    
    private String id;
    @NotBlank(message = "Digite o nome do Livro")
    @NotEmpty(message = "Digite o Nome do Autor")
    private String nome;
    private String autor;
    @NotEmpty(message = "Os generos do livro deve ser informado")
    private List<String> generoDoLivro;
    @Size(min=4,max=4, message = "A data do Livro Deve ser infromado")
    private String anoDeLancamento;
    @Positive(message = "O valor deve ser Informado")
    private Double valorDoLivro;
    private Double numeroDePag;
 
    
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
    public List<String> getGeneroDoLivro() {
        return generoDoLivro;
    }
    public void setGeneroDoLivro(List<String> generoDoLivro) {
        this.generoDoLivro = generoDoLivro;
    }
    public String getAnoDeLancamento() {
        return anoDeLancamento;
    }
    public void setAnoDeLancamento(String anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
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
   

}
