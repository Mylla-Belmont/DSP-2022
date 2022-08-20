import java.io.*;
import java.util.Scanner;

public class L1Q1 {
    public static void main(String[] args) throws Exception {

        InputStream is = new FileInputStream("C:\Users\Camila\Documents\GitHub\DSP-2022-1\Lista_01\arquivo.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();

        while(s != null){
            if(s.contains(subString))
                System.out.println(s);
            s = br.readLine();
        }
        
        input.close();
        br.close();
    }
}