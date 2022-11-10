package trabalho_02.example.trabalho_02.ui;

import javax.swing.JOptionPane;
import org.springframework.boot.CommandLineRunner;
import trabalho_02.example.trabalho_02.dao.AtorDAO;
import trabalho_02.example.trabalho_02.entity.Ator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Autowired;

@ComponentScan("trabalho_02.example.trabalho_02")
public class CRUDatores implements CommandLineRunner {
    @Autowired
    private AtorDAO baseAtor;

    public static void obterFilmes(Ator ator) {
        
    }

    public void run(String... args) throws Exception {
        char selection;
        String menu = "Escolha uma opção: \n" +
                        "1 - Inserir Ator \n" +
                        "2 - Atualizar Ator por id \n" +
                        "3 - Remover Ator por id \n" +
                        "4 - Exibir Ator por id \n" +
                        "5 - Exibir todos os Atores \n" +
                        "6 - Sair \n";
        do {
            Ator ator;
            String id_atores;
            selection = JOptionPane.showInputDialog(menu).charAt(0);

            switch (selection) {
                case '1':   // SALVAR
                    ator = new Ator();
                    obterFilmes(ator);
                    baseAtor.save(ator);
                    break;

                case '2':
                    break;

                case '3':
                    break;
                    
                case '4':
                    break;
                    
                case '5':
                    break;
                    
                case '6':
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (selection != '6');
    }
}
