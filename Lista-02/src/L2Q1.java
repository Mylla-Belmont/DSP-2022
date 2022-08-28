import java.io.*;
import java.util.Scanner;

public class L2Q1 {
    public static void main(String[] args) throws Exception {

        System.out.println("Digite o nome do arquivo:");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();

        InputStream is = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();

        System.out.println("Agora digite a substring do arquivo:");
        String subString = input.nextLine();

        while(s != null){
            if(s.contains(subString))
                System.out.println(s);
            s = br.readLine();
        }
        input.close();
        br.close();
    }
}