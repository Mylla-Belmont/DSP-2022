package trabalho_02;

import javax.swing.JOptionPane;
import trabalho_02.dao.AtorDAO;
import trabalho_02.dao.FilmeDAO;
import trabalho_02.dao.AtorJPADAOquery;
import trabalho_02.dao.FilmeJPADAOquery;

public class Menu {
    public static void main( String[] args ) {
        //FilmeDAO baseFilmeDAO = new FilmeJPADAOquery();
        AtorDAO  baseAtorDAO = new AtorJPADAOquery();

        char selection;
        String menu = "Escolha uma opção: \n" +
                        "1 - Listar ator por ID \n" +
                        "2 - Listar filme por ID \n" +
                        "3 - Listar filmes por ator \n" +
                        "4 - Listar filmes por ano \n" +
                        "5 - Listar filmes por string \n" +
                        "6 - Listar todos os filmes \n" +
                        "7 - Listar atores por filme \n" +
                        "8 - Listar atores por ano \n" + 
                        "9 - Sair \n";

        do {
            selection = JOptionPane.showInputDialog(menu).charAt(0);
            switch (selection) {
                case '1':
                    String id_ator = JOptionPane.showInputDialog("Digite o ID do ator"); 
                    baseAtorDAO.findById(Integer.parseInt(id_ator));
                    break;
                case '2':
                    break;

                case '9':
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while(selection != '9');
    }
}
