package trabalho_02.example.trabalho_02.ui;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.CommandLineRunner;
import trabalho_02.example.trabalho_02.dao.AtorDAO;
import trabalho_02.example.trabalho_02.entity.Ator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Autowired;

@ComponentScan("trabalho_02.example.trabalho_02")
public class CRUDatores implements CommandLineRunner {
    @Autowired
    private AtorDAO baseAtor;

    public static void obterAtor(Ator ator) {
        String nome = JOptionPane.showInputDialog("Nome", ator.getNome());
        String data = JOptionPane.showInputDialog("Data de nascimento", ator.getDataNascimento());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate dataNascimento = LocalDate.parse(data, formatter);
        ator.setNome(nome);
        ator.setDataNascimento(dataNascimento);
        ator.setFilmes(null);
    }

    public void run(String... args) throws Exception {
        char selection;
        String menu = "Escolha uma opção: \n" +
                        "1 - Inserir Ator \n" +
                        "2 - Atualizar Ator por id \n" +
                        "3 - Remover Ator por id \n" +
                        "4 - Exibir todos os Atores \n" +
                        "5 - Exibir todos os Atores \n" +
                        "6 - Sair \n";
        do {
            Ator ator;
            int id_atores;
            List<Ator> atores = new ArrayList<>();
            selection = JOptionPane.showInputDialog(menu).charAt(0);

            switch (selection) {
                case '1':   // SALVAR
                    ator = new Ator();
                    obterAtor(ator);
                    baseAtor.save(ator);
                break;

                case '2':   // ATUALIZAR POR ID
                    id_atores = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do ator:"));
                    ator = baseAtor.findById(id_atores);
                    if (ator != null) {
                        obterAtor(ator);
                        baseAtor.save(ator);
                    } else {
                        JOptionPane.showMessageDialog(null, "Id inválido!");
                    }
                break;

                case '3':   // DELETAR POR ID
                    id_atores = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do ator:"));
                    ator = baseAtor.findById(id_atores);
                    if (ator != null) {
                        baseAtor.deleteById(ator.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Id inválido!");
                    } 
                break;
                  
                case '4':   // EXIBIR TODOS
                    atores = baseAtor.findAll();
                    for (Ator ator2 : atores) {
                        JOptionPane.showMessageDialog(null, ator2.getNome() + ", " + ator2.getDataNascimento());
                    }
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
