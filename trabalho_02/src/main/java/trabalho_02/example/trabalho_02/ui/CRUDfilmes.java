package trabalho_02.example.trabalho_02.ui;

// import java.util.List;
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

    // public static void lista_Filmes(List<Filme> filmes) {
    //     StringBuilder listagem = new StringBuilder();
    //     for (Filme filme : filmes) {
    //         listagem.append(filme).append("\n");
    //     }
    //     JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum filme encontrado" : listagem);
    // }

    // public static void listaFilme(Filme filme) {
    //     JOptionPane.showMessageDialog(null, filme);
    // }

    public void run(String... args) throws Exception {
        char selection;
        String menu = "Escolha uma opção: \n" +
                        "1 - Inserir filme \n" +
                        "2 - Atualizar filme por id \n" +
                        "3 - Remover filme por id \n" +
                        "4 - Exibir filme por id \n" +
                        "5 - Exibir todos os filmes \n" +
                        "6 - Sair \n";
        do {
            Filme filme;
            int id_filmes;
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
                    } break;

                case '3':  // DELETAR POR ID   
                    id_filmes = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do filme:"));
                    filme = baseFilme.findById(id_filmes);
                    if(filme != null) {
                        baseFilme.deleteById(filme.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Id inválido!");
                    } break;

                case '4':  // CONSULTAR POR ID
                    break;

                case '5':  // LISTA TODOS OS FILMES
                    break;

                case '6':
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while(selection != '6');
    }  
}
