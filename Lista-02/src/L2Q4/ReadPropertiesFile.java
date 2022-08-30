package L2Q4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class ReadPropertiesFile {
    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        Scanner scanner = new Scanner(System.in);

        try {
            prop.load(new FileInputStream("config.properties"));
            String firstLine = prop.getProperty("linha_inicial");
            String endLine = prop.getProperty("linha_final");

            int inicio = Integer.parseInt(firstLine);
            int fim = Integer.parseInt(endLine);

            System.out.println("Qual arquivo deseja ler?");
            String fileName = scanner.nextLine();

            InputStream is = new FileInputStream(fileName);
            Scanner entrada = new Scanner(is);

            int cont = 1;
            while (entrada.hasNextLine()) {
                if (cont >= inicio && cont <= fim)
                    System.out.println(entrada.nextLine());
                else { entrada.nextLine(); } 
                cont++;
            }
            entrada.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        scanner.close();
    }
}
