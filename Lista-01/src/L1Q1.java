import java.io.*;
import java.util.Scanner;

public class L1Q1 {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Digite o nome do arquivo:");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();

        InputStream is = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();

        OutputStream os= new FileOutputStream(fileName);
        OutputStreamWriter osw= new OutputStreamWriter(os);
        BufferedWriter bw= new BufferedWriter(osw);

        System.out.println("Digite N1:");
        String n1 = input.nextLine();
        bw.write(n1);

        bw.newLine();

        System.out.println("Digite N2:");
        String n2 = input.nextLine();
        bw.write(n2);
       
        while(s != null) {
            System.out.println(s);
            s = br.readLine();
        }
        
        input.close();
        br.close();
        bw.close();
    }
}
