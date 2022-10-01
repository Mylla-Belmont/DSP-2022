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
            String sql = "insert into alunos(id, cpf, matricula, nome, email, telefone)" + 
                         "values(default, '" + cpf + "','" + matricula + "','" + nome + "','" + email + "','" + telefone + "')";
            bank.update(sql);
            System.out.println("\n" + nome + " adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listAlunos () {
        try {
            ConnectionPGSQL bank = connect();
            String sql = "select id, cpf, matricula, nome, email, telefone from alunos";
            ResultSet result = bank.select(sql);
            while (result.next()) {
                int id = result.getInt("id");
                int cpf = result.getInt("cpf");
                int matricula = result.getInt("matricula");
                String nome = result.getString("nome");
                String email = result.getString("email");
                int telefone = result.getInt("telefone");
                System.out.println("{" + id + ", " + cpf + ", " + matricula + ", " + nome + ", " + email + ", " + telefone + "}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
