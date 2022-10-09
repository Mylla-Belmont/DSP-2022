package com.lista_07.dao;

import com.lista_07.entidade.Aluno;

public interface AlunoDAO {
    
    public void salvar(Aluno aluno);

    public void deletar(int id);

    public Aluno consultar(int id);

    public void alterar(Aluno aluno, int id, int opcao);
}
