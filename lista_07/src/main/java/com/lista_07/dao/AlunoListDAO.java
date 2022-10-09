package com.lista_07.dao;

import java.util.ArrayList;
import java.util.List;

import com.lista_07.entidade.Aluno;

public class AlunoListDAO implements AlunoDAO{

    private List<Aluno> alunos;
    private static int idProximo = 1;

    public AlunoListDAO() {
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
            aluno.setId(idProximo++);
            alunos.add(aluno);
        } else {
            int posicaoNaLista = findIndex(aluno.getId());
			alunos.set(posicaoNaLista, aluno);
        }
    }

    public void deletar(int id) {
        alunos.remove(consultar(id));
    }

    public Aluno consultar(int id) {
        for (Aluno al : this.alunos) {
			if (al.getId() == id) {
				return al;
			}
		} return null;
    }
    
}
