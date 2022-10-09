package lista_07.lista_07;

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

	private static void buscarAluno(Aluno aluno) {
		String id = JOptionPane.showInputDialog("ID", aluno.getId());
		String cpf = JOptionPane.showInputDialog("CPF", aluno.getCpf());
		String matricula  = JOptionPane.showInputDialog("MATRICULA", aluno.getMatricula());
		String nome  = JOptionPane.showInputDialog("NOME", aluno.getNome());
		String email  = JOptionPane.showInputDialog("EMAIL", aluno.getEmail());
		String telefone  = JOptionPane.showInputDialog("TELEFONE", aluno.getTelefone());
		aluno.setId(Integer.parseInt(id));
		aluno.setCpf(cpf);
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setTelefone(telefone);
	}

	private static void listaAluno(Aluno aluno) {
		JOptionPane.showMessageDialog(null, aluno == null ? "Aluno não  encontrado" : aluno);
	}

	public void run(String... args) throws Exception {
		String menu = "Escolha uma opção: \n" +
					  "1 - Inserir \n" +
					  "2 - Atualizar \n" +
					  "3 - Remover \n" + 
					  "4 - Consultar \n" + 
					  "5 - Sair";
		char selecao;

		do {
			Aluno aluno;
			String id;
			selecao = JOptionPane.showInputDialog(menu).charAt(0);

			switch(selecao) {
				// Inserir 
				case '1':
					aluno = new Aluno();
					buscarAluno(aluno);
					cDao.salvar(aluno);
					break;
				// Atualizar
				case '2':
					id = JOptionPane.showInputDialog("Digite o id do aluno para alterar:");
					aluno = cDao.consultar(Integer.parseInt(id));
					buscarAluno(aluno);
					cDao.salvar(aluno);
					break;
				// Remover 
				case '3':
					id = JOptionPane.showInputDialog("Digite o id do aluno para remover:");
					aluno = cDao.consultar(Integer.parseInt(id));
					if (aluno != null) {
						cDao.deletar(aluno.getId());
					} else {
						JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
					}break;
				// Consultar
				case '4':
					id = JOptionPane.showInputDialog("Digite o id do aluno para consultar");
					aluno = cDao.consultar(Integer.parseInt(id));
					listaAluno(aluno);
					break;
				case '5':
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		} while(selecao != '5');
	}
}