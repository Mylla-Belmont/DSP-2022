import java.sql.ResultSet;

public class BankAccess {
    
    private ConnectionPGSQL connect (){
        ConnectionPGSQL bank = new ConnectionPGSQL();
        bank.connect("jdbc:postgresql://localhost/postgres", "postgres", "creepypasta");  
        return bank;
    }

    public void insertAluno (String cpf, String matricula, String nome, String email, String telefone) {
        ConnectionPGSQL bank = connect();
        String sql = "insert into alunos(id, cpf, matricula, nome, email, telefone)" + 
                     "values(default, '" + cpf + "','" + matricula + "','" + nome + "','" + email + "','" + telefone + "')";
        bank.update(sql);
        bank.disconnect();
    }

    public void listAlunos () {
        ConnectionPGSQL bank = connect();
        try {
            String sql = "select id, cpf, matricula, nome, email, telefone from alunos";
            ResultSet result = bank.select(sql);
            while (result.next()) {
                String id = result.getString("id");
                String cpf = result.getString("cpf");
                String matricula = result.getString("matricula");
                String nome = result.getString("nome");
                String email = result.getString("email");
                String telefone = result.getString("telefone");
                System.out.println("{" + id + ", " + cpf + ", " + matricula + ", " + nome + ", " + email + ", " + telefone + "}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } bank.disconnect();
    }
}
