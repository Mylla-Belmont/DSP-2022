import java.util.List;

public class Livros {
    
    public Livros() {}
    
    public Livros(List<Livro> livros) {
        this.livros = livros;
    }
    
    private List<Livro> livros;

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public String toString() {
        return this.livros.toString();
    }
}
