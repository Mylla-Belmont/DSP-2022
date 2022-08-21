import java.io.*;
import java.util.Scanner;

public class L1Q2 {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Qual o arquivo de origem?");
        Scanner input = new Scanner(System.in);
        String originFile = input.nextLine();

        InputStream is = new FileInputStream(originFile);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        OutputStream os = new FileOutputStream("destino.txt");

        int c;
        while(br.ready()){
            c = isr.read();
            os.write(c);
        }

        long time = System.currentTimeMillis();
        System.out.println("Cópia executada com sucesso em: \n" + time + " milisegundos");
        
        input.close();
        is.close();  
        os.close();   
    }
}
