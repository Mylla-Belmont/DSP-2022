import java.util.Scanner; 

public class Menu {

    private static void insertAluno (Scanner scanner) {
        System.out.println("Digite o id:");
        String id_t = scanner.nextLine();
        System.out.println("Digite o cpf:");
        String cpf_t = scanner.nextLine();
        System.out.println("Digite a matricula:");
        String matricula_t = scanner.nextLine();
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite o email:");
        String email = scanner.nextLine();
        System.out.println("Digite o telefone:");
        String telefone_t = scanner.nextLine();
        
        int id = Integer.parseInt(id_t);
        int cpf = Integer.parseInt(cpf_t);
        int matricula = Integer.parseInt(matricula_t);
        int telefone = Integer.parseInt(telefone_t);

        BankAccess bank = new BankAccess();
        bank.insertAluno(id, cpf, matricula, nome, email, telefone);
        System.out.println("Aluno inserido com sucesso!");
    }  
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione o que deseja:");
            System.out.println("1 - Inserir novo aluno:");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Sair");

            String input = scanner.nextLine();

            if(input.equals("1")) {
                insertAluno(scanner);
            } else if(input.equals("2")) {
                // LISTAR ALUNOS
            } else if (input.equals("3")) {
                System.out.println("Sistema fechado");
                break;
            } else
                continue;
        }
        scanner.close();
    }
}
