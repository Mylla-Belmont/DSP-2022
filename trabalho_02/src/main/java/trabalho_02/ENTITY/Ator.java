package trabalho_02.ENTITY;

import javax.persistence.*;

//Named Query

@Entity
@Table(name = "atores")
public class Ator {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private int anoLancamento;

    public Ator() {}

    public Ator(int id, String titulo, int anoLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String toString() {
        return  "Ator [id=" + id + 
                ", titulo=" + titulo + 
                ", anoLancamento=" + anoLancamento + "]";
    }
}
