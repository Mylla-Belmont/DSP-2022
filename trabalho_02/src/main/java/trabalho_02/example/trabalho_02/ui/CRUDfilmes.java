package trabalho_02.example.trabalho_02.ui;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.springframework.boot.CommandLineRunner;
import trabalho_02.example.trabalho_02.entity.Filme;
import trabalho_02.example.trabalho_02.dao.FilmeDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Autowired;

@ComponentScan("trabalho_02.example.trabalho_02")
public class CRUDfilmes implements CommandLineRunner {
    @Autowired
    private FilmeDAO baseFilme;
    
    public static void obterFilmes(Filme filme) {
        String titulo = JOptionPane.showInputDialog("Titulo", filme.getTitulo());
        String anoLancamento = JOptionPane.showInputDialog("Ano de lançamento", filme.getAnoLancamento());
        filme.setTitulo(titulo);
        filme.setAnoLancamento(anoLancamento);
    }

    public void run(String... args) throws Exception {
        char selection;
        String menu = "Escolha uma opção: \n" +
                        "1 - Inserir filme \n" +
                        "2 - Atualizar filme por id \n" +
                        "3 - Remover filme por id \n" +
                        "4 - Exibir todos os filmes \n" +
                        "5 - Listar filmes por ano \n" +
                        "6 - Listar filmes por string \n" +
                        "7 - Sair \n";
        do {
            Filme filme;
            int id_filmes;
            List<Filme> filmes = new ArrayList<>();
            selection = JOptionPane.showInputDialog(menu).charAt(0);

            switch (selection) {
                case '1':   // SALVAR   
                    filme = new Filme();
                    obterFilmes(filme);
                    baseFilme.save(filme);
                    break;

                case '2':   // ATUALIZAR POR ID
                    id_filmes = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do filme:"));
                    filme = baseFilme.findById(id_filmes);
                    if(filme != null) {
                        obterFilmes(filme);
                        baseFilme.save(filme);
                    }else {
                        JOptionPane.showMessageDialog(null, "Id inválido!");
                    }
                break;

                case '3':  // DELETAR POR ID   
                    id_filmes = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do filme:"));
                    filme = baseFilme.findById(id_filmes);
                    if(filme != null) {
                        baseFilme.deleteById(filme.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Id inválido!");
                    }
                break;

                case '4':  // EXIBIR TODOS
                    filmes = baseFilme.findAll();
                    for(Filme filme2 : filmes) {
                        JOptionPane.showMessageDialog(null, filme2.getTitulo() + ", " + filme2.getAnoLancamento());
                    } 
                break;

                case '5':  // EXIBIR FILMES POR DETERMINADO ANO
                    String anoLancamento = JOptionPane.showInputDialog("Digite o ano de lançamento do filme:");
                    filmes = baseFilme.listByYear(anoLancamento);
                    for (Filme filme2 : filmes) {
                        JOptionPane.showMessageDialog(null, filme2.getTitulo() + ", " + filme2.getAnoLancamento());
                    }
                break;

                case '6':  // EXIBIR TITULO POR STRING
                    String stringTitulo = JOptionPane.showInputDialog("Digite a string do titulo:");
                    filmes = baseFilme.listByString(stringTitulo);
                    for (Filme filme2 : filmes) {
                        JOptionPane.showMessageDialog(null, filme2.getTitulo() + ", " + filme2.getAnoLancamento());
                    }
                break;

                case '7':
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while(selection != '7');
    }  
}
