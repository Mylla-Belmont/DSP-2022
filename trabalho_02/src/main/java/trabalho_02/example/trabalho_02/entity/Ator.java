package trabalho_02.example.trabalho_02.entity;

import lombok.*;
import java.util.List;
import javax.persistence.*;
import java.time.LocalDate;

@NamedQuery(name="Ator.findByYear", query="select a from Ator a where a.dataNascimento = :dataNascimento")

@Entity
@Table(name = "atores")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Ator {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private int id;
	
	@NonNull @Getter @Setter private String nome;
	@Getter @Setter private LocalDate dataNascimento;

    @ManyToMany(mappedBy = "atores")
	@Getter @Setter private List<Filme> filmes;
}
