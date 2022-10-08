package lista_07.lista_07.dao;

import lista_07.lista_07.entidade.Aluno;

public interface ClienteDAO {
    
    public void salvar(Aluno aluno);

    public void deletar(int id);

    public Aluno consultar(int id);

    // alterar - update
}
