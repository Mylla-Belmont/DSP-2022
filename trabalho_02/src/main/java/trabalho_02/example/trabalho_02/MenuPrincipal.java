package trabalho_02.example.trabalho_02;

import javax.swing.JOptionPane;
import trabalho_02.example.trabalho_02.ui.CRUDatores;
import trabalho_02.example.trabalho_02.ui.CRUDfilmeAtores;
import trabalho_02.example.trabalho_02.ui.CRUDfilmes;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("trabalho_02.example.trabalho_02")
@EnableJpaRepositories("trabalho_02.example.trabalho_02.dao")
public class MenuPrincipal {

	public static void main(String[] args) {

		char selection;
        String menu = "Escolha uma opção: \n" +
                        "1 - CRUD Filmes \n" +
                        "2 - CRUD Atores \n" +
                        "3 - CRUD filme/ator \n" +
                        "4 - sair \n";

		do {
			selection = JOptionPane.showInputDialog(menu).charAt(0);
			switch (selection) {
				case '1':   // CRUD FILMES
					SpringApplicationBuilder builderFilme = new SpringApplicationBuilder(CRUDfilmes.class);
					builderFilme.headless(false).run(args);
					break;

				case '2':   // CRUD ATORES
					SpringApplicationBuilder builderAtor = new SpringApplicationBuilder(CRUDatores.class);
					builderAtor.headless(false).run(args);
					break;

				case '3':  // CRUD FILMES OU ATORES
					SpringApplicationBuilder builderFilmeAtores = new SpringApplicationBuilder(CRUDfilmeAtores.class);
					builderFilmeAtores.headless(false).run(args);
					break;

				case '4':
					break;

				default:
					JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		} while(selection != '4');
	}
}
