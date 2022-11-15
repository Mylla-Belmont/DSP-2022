package trabalho_02.entity;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;

@NamedQueries({
    @NamedQuery(name="Ator.findMoviesByActor", query = "select A.nome, F.titulo from Ator A, Filme F where titulo = :titulo"),
    @NamedQuery(name="Ator.findActorsByYear", query = "select nome, dataNascimento from Ator where dataNascimento = :ano")
})

@Entity 
@Table(name = "Ator")
public class Ator {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    Set<Ator> filme_ator;

    private String nome;
    private LocalDateTime dataNascimento;

    public Ator() {}

    public Ator(int id, Set<Ator> filme_ator, String nome, LocalDateTime dataNascimento) {
        this.id = id;
        this.filme_ator = filme_ator;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setfilme_ator(Set<Ator> filme_ator) {
        this.filme_ator = filme_ator;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public Set<Ator> getfilme_ator() {
        return filme_ator;
    }

    public String toString() {
        return "Ator [id=" + id + 
                ", filme_ator=" + filme_ator + 
                ", nome=" + nome + 
                ", dataNascimento=" + dataNascimento + "]";
    }
}
