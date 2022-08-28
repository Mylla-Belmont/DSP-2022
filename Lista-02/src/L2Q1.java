import java.io.*;
import java.util.Scanner;

public class L2Q1 {
    public static void main(String[] args) throws Exception {

        System.out.println("Digite o nome do arquivo:");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();

        System.out.println("Agora digite a substring do arquivo:");
        System.out.println("*Digite /stop/ para parar* \n");
        Scanner input2 = new Scanner(System.in);
        PrintStream ps= new PrintStream(fileName);
        
        while(input2.hasNextLine()) {
            ps.println(input2.nextLine());
            if(input2.nextLine().equals("/stop/"))
                break;
        }

        InputStream is = new FileInputStream(fileName);
        Scanner input3 = new Scanner(is);

        while(input3.hasNextLine()) {
            System.out.println(input3.nextLine());
        }

        input3.close();
        input2.close();
        input.close();
        ps.close();
    }
}