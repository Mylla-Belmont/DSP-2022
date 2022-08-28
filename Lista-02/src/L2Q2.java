import java.io.*;
import java.util.Scanner;

public class L2Q2 {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do 1° arquivo:");
        String fileName1 = input.nextLine();
        InputStream is1 = new FileInputStream(fileName1);
        Scanner readFile1 = new Scanner(is1);

        System.out.println("Digite o nome do 2° arquivo:");
        String fileName2 = input.nextLine();
        InputStream is2 = new FileInputStream(fileName2);
        Scanner readFile2 = new Scanner(is2);

        System.out.println("Digite o nome do 3° arquivo:");
        String fileName3 = input.nextLine();
        PrintStream ps = new PrintStream(fileName3);

        while(readFile1.hasNextLine()){
            ps.println(readFile1.nextLine());
        }

        while(readFile2.hasNextLine()){
            ps.println(readFile2.nextLine());
        }

        File file = new File("C:\\Users\\Camila\\Documents\\GitHub\\DSP-2022-1\\Lista-02" + fileName3);

        if(file.exists())
            System.out.println("Cópia executada com sucesso!");
        
        ps.close();
        input.close();
        readFile1.close();
        readFile2.close();
    }
}