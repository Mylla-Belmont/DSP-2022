package trabalho_02.example.trabalho_02.ui;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.springframework.boot.CommandLineRunner;
import trabalho_02.example.trabalho_02.entity.Ator;
import trabalho_02.example.trabalho_02.entity.Filme;
import trabalho_02.example.trabalho_02.dao.AtorDAO;
import trabalho_02.example.trabalho_02.dao.FilmeDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.domain.EntityScan;

@ComponentScan("trabalho_02.example.trabalho_02")
public class CRUDfilmes implements CommandLineRunner {
    @Autowired
    private FilmeDAO baseFilme;
    private AtorDAO baseAtor;
    
    public static void obterFilmes(Filme filme, AtorDAO baseAtor) {
        String titulo = JOptionPane.showInputDialog("Titulo", filme.getTitulo());
        String anoLancamento = JOptionPane.showInputDialog("Ano de lançamento", filme.getAnoLancamento());
    
        filme.setTitulo(titulo);
        filme.setAnoLancamento(anoLancamento);
    }

    public static void listaFilme(Filme filme) {
        JOptionPane.showMessageDialog(null, filme == null ? "Nenhum cliente encontrado" : filme);
    }

    public static void listaFilmes(List<Filme> filmes) {
        StringBuilder listagem = new StringBuilder();
        for (Filme filme : filmes) {
            listagem.append(filme).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum filme encontrado" : listagem);
    }

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
            String id_filmes;
            selection = JOptionPane.showInputDialog(menu).charAt(0);
            switch (selection) {
                case '1':   // SALVAR
                    filme = new Filme();
                    obterFilmes(filme, baseAtor);
                    baseFilme.save(filme);
                    break;

                case '2':   // ATUALIZAR POR ID
                    id_filmes = JOptionPane.showInputDialog("Digite o ID do filme");
                    filme = baseFilme.findById(Integer.parseInt(id_filmes));
                    // obterFilmes(filme);
                    baseFilme.save(filme);
                    break;

                case '3':  // DELETAR POR ID
                    id_filmes = JOptionPane.showInputDialog("Digite o ID do filme");
                    filme = baseFilme.findById(Integer.parseInt(id_filmes));
                    if(filme != null) {
                        baseFilme.deleteById(filme.getId());
                    } else 
                        JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o cliente não encontrado.");
                    break;

                case '4':  // CONSULTAR POR ID
                    id_filmes = JOptionPane.showInputDialog("Digite o ID do filme");
                    filme = baseFilme.findById(Integer.parseInt(id_filmes));
                    listaFilme(filme);
                    break;

                case '5':  // LISTA TODOS OS FILMES
                    listaFilmes(baseFilme.findAll());
                    break;

                case '6':
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while(selection != '6');
    }  
}
