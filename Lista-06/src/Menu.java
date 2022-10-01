import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione o que deseja:");
            System.out.println("1 - Inserir novo aluno:");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Sair");

            String input = scanner.nextLine();

            if(input.equals("1")) {
                // INSERIR ALUNO
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
