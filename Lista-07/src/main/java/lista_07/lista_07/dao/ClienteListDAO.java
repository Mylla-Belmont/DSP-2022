package lista_07.lista_07.dao;

import java.util.ArrayList;
import java.util.List;

import lista_07.lista_07.entidade.Aluno;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteListDAO implements ClienteDAO {
    
    private List<Aluno> alunos;

    private static int ProxId = 1;

    public ClienteListDAO() {
        this.alunos = new ArrayList<Aluno>();
    }

    private int findIndex(int id) {
		for (int i=0; i < alunos.size(); i++) {
			if (alunos.get(i).getId() == id) {
				return i;
			}
		} return -1;
	}

    public void salvar(Aluno aluno) {
        if(aluno.getId() == 0) {
            aluno.setId(ProxId++);
            alunos.add(aluno);
        } else {
            int posicaoLista = findIndex(aluno.getId());
            alunos.set(posicaoLista, aluno); 
        }
    }

    public void deletar(int id) {
        alunos.remove(consultar(id));
    }

    public Aluno consultar(int id) {
		for (Aluno cl : this.alunos) {
			if (cl.getId() == id) {
				return cl;
			}
		} return null;
	}
}
