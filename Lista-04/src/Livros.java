import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "biblioteca")
public class Livros {
    
    public Livros() {}
    
    public Livros(List<Livro> livros) {
        this.livros = livros;
    }

    @JacksonXmlElementWrapper(localName = "livros")
    @JacksonXmlProperty(localName = "livro")
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
