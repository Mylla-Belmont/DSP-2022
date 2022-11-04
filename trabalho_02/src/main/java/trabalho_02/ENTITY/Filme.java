package trabalho_02.ENTITY;

import java.time.LocalDateTime;
import javax.persistence.*;

//NamedQuery

@Entity
@Table(name = "filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome;
    private LocalDateTime dataNascimento;

    public Filme() {}

    public Filme(int id, String nome, LocalDateTime dataNascimento) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public String toString() {
        return  "Filme [id=" + id + 
                ", nome=" + nome + 
                ", dataNascimento=" + dataNascimento + "]";
    }

    
}
