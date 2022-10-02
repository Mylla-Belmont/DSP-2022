import java.util.Scanner; 

public class Menu {

    private static void listAlunos (Scanner scanner) {
        BankAccess bank = new BankAccess();
        bank.listAlunos();
    }

    private static void insertAluno (Scanner scanner) {
        System.out.println("Digite o cpf:");
        String cpf = scanner.nextLine();
        System.out.println("Digite a matricula:");
        String matricula = scanner.nextLine();
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite o email:");
        String email = scanner.nextLine();
        System.out.println("Digite o telefone:");
        String telefone = scanner.nextLine();
        
        BankAccess bank = new BankAccess();
        bank.insertAluno(cpf, matricula, nome, email, telefone);
    }  
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelecione o que deseja:");
            System.out.println("1 - Inserir novo aluno:");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Sair");

            String input = scanner.nextLine();
            if(input.equals("1")) {
                insertAluno(scanner);
            } else if(input.equals("2")) {
                listAlunos(scanner);
            } else if (input.equals("3")) {
                System.out.println("Sistema fechado");
                break;
            } else
                continue;
        }
        scanner.close();
    }
}
