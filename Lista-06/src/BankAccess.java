import java.sql.ResultSet;

public class BankAccess {

    private ConnectionPGSQL connect (){
        ConnectionPGSQL bank = new ConnectionPGSQL();
        bank.connect("jdbc:postgresql://localhost:Lista-06", "postgres", "P_0stGr#eSqL");  
        return bank;
    }

    public void insertAluno (int cpf, int matricula, String nome, String email, int telefone) {
        try {
            ConnectionPGSQL bank = connect();
            String sql = "insert into aluno(id, cpf, matricula, nome, email, telefone)" + 
                         "values(default, '" + cpf + "','" + matricula + "','" + nome + "','" + email + "','" + telefone + "')";
            bank.update(sql);
            System.out.println("\n" + nome + " adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
