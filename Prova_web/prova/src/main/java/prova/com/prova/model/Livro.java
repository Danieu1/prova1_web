package prova.com.prova.model;

public class Livro{
    private String Nome;
    private String Autor;
    private int ISBN;   //id
    private  float Preco;
    private String Editora;
    private String Genero;

    public Livro() {

    }
    public Livro(String Nome, String Autor, int ISBN, float Preco, String Editora, String Genero) {
        this.Nome = Nome;
        this.Autor = Autor;
        this.ISBN = ISBN;
        this.Preco = Preco;
        this.Editora = Editora;
        this.Genero= Genero; 
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        this.Genero = genero;
    }

    

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public Float getPreco() {
        return Preco;
    }

    public void setPreco(Float preco) {
        this.Preco= preco;
    }

    public String getEditora() {
        return Editora;
    }

    public void setEditora( String Editora) {
        this.Editora = Editora;
    }

}