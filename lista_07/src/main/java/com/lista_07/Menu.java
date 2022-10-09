package com.lista_07;

import com.lista_07.entidade.Aluno;

import javax.swing.JOptionPane;

import com.lista_07.dao.AlunoDAO;
import com.lista_07.dao.AlunoJDBCDAO;

public class Menu {

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

    public static void main( String[] args ) {
        AlunoDAO baseAlunoDAO = new AlunoJDBCDAO();
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
                        baseAlunoDAO.salvar(aluno);
                        break;
                    // Atualizar
                    case '2':
                        id = JOptionPane.showInputDialog("Digite o id do aluno para alterar:");
                        String opcao = "Digite o que deseja alterar:\n" + 
                                       "1 - cpf:\n" + 
                                       "2 - matricula:\n" + 
                                       "3 - nome:\n" + 
                                       "4 - email:\n" + 
                                       "5 - telefone:"; 
                        String escolha = JOptionPane.showInputDialog(opcao);
                        aluno = baseAlunoDAO.consultar(Integer.parseInt(id));
                        baseAlunoDAO.alterar(aluno, Integer.parseInt(id), Integer.parseInt(escolha));
                        break;
                    // Remover 
                    case '3':
                        id = JOptionPane.showInputDialog("Digite o id do aluno para remover:");
                        aluno = baseAlunoDAO.consultar(Integer.parseInt(id));
                        if (aluno != null) {
                            baseAlunoDAO.deletar(aluno.getId());
                        } else {
                            JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
                        }break;
                    // Consultar
                    case '4':
                        id = JOptionPane.showInputDialog("Digite o id do aluno para consultar");
                        aluno = baseAlunoDAO.consultar(Integer.parseInt(id));
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
