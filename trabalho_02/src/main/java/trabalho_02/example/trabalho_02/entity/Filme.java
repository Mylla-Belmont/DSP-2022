package trabalho_02.example.trabalho_02.entity;

import lombok.*;
import java.util.List;
import javax.persistence.*;

@NamedQuery(name="Filme.findByYear", query="select f from Filme f where f.anoLancamento = :anoLancamento")

@Entity
@Table(name = "filmes")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Filme {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private int id;

    @NonNull @Getter @Setter private String titulo;
	@Getter @Setter private String anoLancamento;

    @ManyToMany
    @JoinTable(
        name = "atoresDofilme",
        joinColumns = @JoinColumn(name = "id_filme"),
        inverseJoinColumns = @JoinColumn(name = "id_ator"))
	@Getter @Setter private List<Ator> atores;
}
