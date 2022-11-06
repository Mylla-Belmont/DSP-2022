package trabalho_02.entity;

import java.util.Set;
import javax.persistence.*;

@NamedQueries({
    @NamedQuery(name="Filme.findById", query="select * from Filme where id = :id"),
    @NamedQuery(name="Filme.findByString", query ="select * from Filme where titulo like :stg"),
})

@Entity
@Table(name = "filme")
public class Filme {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @ManyToMany
    Set<Filme> atores_filme;

    private int id;
    private String titulo;
    private int anoLancamento;

    public Filme() {}

    public Filme(Set<Filme> atores_filme, int id, String titulo, int anoLancamento) {
        this.atores_filme = atores_filme;
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

    public void setAtores(Set<Filme> atores_filme) {
        this.atores_filme = atores_filme;
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

    public Set<Filme> getAtores() {
        return atores_filme;
    }

    public String toString() {
        return "Ator [atores_filme=" + atores_filme + 
                ", id=" + id + 
                ", titulo=" + titulo + 
                ", anoLancamento=" + anoLancamento + "]";
    }
}
