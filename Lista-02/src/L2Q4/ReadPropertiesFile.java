package L2Q4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class ReadPropertiesFile {
    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo:");
        String input = scanner.nextLine();

        try {
            prop.load(new FileInputStream(input));
            String fileName = prop.getProperty("arquivo");
            String firstLine = prop.getProperty("linha_inicial");
            String endLine = prop.getProperty("linha_final");
            
            System.out.println(fileName);
            System.out.println(firstLine);
            System.out.println(endLine);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        scanner.close();
    }
}
