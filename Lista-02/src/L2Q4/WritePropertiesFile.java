package L2Q4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class WritePropertiesFile {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo:");
        String fileName = input.nextLine();

        System.out.println("Digite a linha inicial de leitura:");
        String firstLine = input.nextLine();

        System.out.println("Digite a linha final de leitura:");
        String endLine = input.nextLine();

        Properties prop = new Properties();
        prop.setProperty("arquivo", fileName);
        prop.setProperty("linha_inicial", firstLine);
        prop.setProperty("linha_final", endLine);
        prop.store(new FileOutputStream("config.properties"), null);

        input.close();
    }
}
