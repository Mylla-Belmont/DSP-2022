package trabalho_02.example.trabalho_02.ui;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.springframework.boot.CommandLineRunner;
import trabalho_02.example.trabalho_02.dao.AtorDAO;
import trabalho_02.example.trabalho_02.entity.Ator;
import trabalho_02.example.trabalho_02.entity.Filme;
import trabalho_02.example.trabalho_02.dao.FilmeDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Autowired;


@ComponentScan("trabalho_02.example.trabalho_02")
public class CRUDfilmeAtores implements CommandLineRunner{
    @Autowired
    private AtorDAO baseAtor;
    @Autowired
    private FilmeDAO baseFilme;

    public void run(String... args) throws Exception {
        char selection;
        String menu = "Escolha uma opção: \n" +
                        "1 - Inserir filmes em atores \n" +
                        "2 - Deletar filmes em atores \n" +
                        "3 - Listar filmes de um ator \n" +
                        "3 - Sair \n";
        do {
            Ator ator;
            Filme filme;
            int id_ator;
            int id_filme;
            List<Ator> atores = new ArrayList<>();
            selection = JOptionPane.showInputDialog(menu).charAt(0);

            switch (selection) {
                case '1':   // INSERIR 
                    id_filme = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do filme:"));
                    filme = baseFilme.findById(id_filme);
                    id_ator = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do ator\n0 - Sair"));
                    ator = baseAtor.findById(id_ator);
                    atores.add(ator);
                    filme.setAtores(atores);
                    baseFilme.save(filme);
                    break;

                // case '2':   // DELETAR
                //     // id_filme = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do filme:"));
                //     // filme = baseFilme.findById(id_filme);
                //     // id_ator = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do ator\n0 - Sair"));
                //     // ator = baseAtor.findById(id_ator);
                //     // filme.getAtores();
                //     // filme.getAtores().remove(ator);
                //     // baseFilme.save(filme);
                //     break;
                    
                // // case '3':   // LISTAR FILMES DE UM ATOR
                // //     String nome = JOptionPane.showInputDialog("Digite o nome do ator:");
                // //     ator = baseAtor.findByName(nome);
                // //     //baseFilme.listByActor(ator.getId());
                // //     break;

                // case '4':
                //     break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (selection != '3');
        
    }
}


// Inserir filmes e atores
// Select em todas essa merda
// Apagar o q precisar 
// Sei lá mano