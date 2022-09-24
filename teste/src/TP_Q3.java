import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

public class TP_Q3 {
    public static void main(String[] args) throws IOException {
 
        System.out.println("Digite o nome do arquivo:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        JsonNode jsonTree = new ObjectMapper().readTree(new File(input));
        Builder csvShemaBuilder = CsvSchema.builder();

        scanner.close();
    }
}
