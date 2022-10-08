package lista_07.lista_07;

import java.util.List;

import javax.swing.JOptionPane;

import lista_07.lista_07.dao.ClienteDAO;
import lista_07.lista_07.entidade.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("lista_07.lista_07")
public class Menu implements CommandLineRunner {

	@Autowired
	private ClienteDAO cDao;

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Menu.class);
		builder.headless(false).run(args);
	}

	public void run(String... args) throws Exception {
		
	}

}
