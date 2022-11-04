package lista_08.dao;

import lista_08.entidade.Aluno;

public interface AlunoDAO {
    
    public void salvar(Aluno aluno);

    public void deletar(int id);

    public Aluno consultar(int id);

    public void alterar(Aluno aluno, int id, int opcao);
}
