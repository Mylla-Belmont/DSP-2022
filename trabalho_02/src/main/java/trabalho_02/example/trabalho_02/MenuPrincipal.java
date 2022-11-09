package trabalho_02.example.trabalho_02;

// import org.springframework.boot.SpringApplication;
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
		SpringApplicationBuilder builder = new SpringApplicationBuilder(CRUDfilmes.class);
		builder.headless(false).run(args);
	}
}
