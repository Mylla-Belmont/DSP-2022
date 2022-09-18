public class Livro {

    private int isbn;
    private String nome;
    private String genero;

    public Livro() {}

    public Livro(int isbn, String nome, String genero) {
        this.isbn = isbn;
        this.nome = nome;
        this.genero = genero;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public String toString() {
        return  "genero=" + genero + ", isbn=" + isbn + ", nome=" + nome;
    }    
}
