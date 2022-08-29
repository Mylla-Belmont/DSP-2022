package L2Q4;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class ReadPropertiesFile {
    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        System.out.println("Digite o nome do arquivo:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        prop.load(ReadPropertiesFile.class.getClassLoader()
                .getResourceAsStream(input));

        System.out.println(prop.getProperty("database"));
        System.out.println(prop.getProperty("dbuser"));
        System.out.println(prop.getProperty("dbpassword"));
        scanner.close();
    }
}
