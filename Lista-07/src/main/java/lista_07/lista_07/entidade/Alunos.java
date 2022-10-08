package lista_07.lista_07.entidade;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Alunos {
    @Getter @Setter private int id;
    @NonNull @Getter @Setter private String cpf;
    @NonNull @Getter @Setter private String matricula; 
    @NonNull @Getter @Setter private String nome; 
    @NonNull @Getter @Setter private String email;
    @NonNull @Getter @Setter private String telefone; 
}
