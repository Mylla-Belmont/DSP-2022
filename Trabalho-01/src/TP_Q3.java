import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TP_Q3 {
    public static void main(String[] args) throws IOException {
 
        System.out.println("Digite o nome do arquivo:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ObjectMapper mapper =  new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Pokemons pokemons = mapper.readValue(new File("pokemons.json"), Pokemons.class);        

        Writer writer = Files.newBufferedWriter(Paths.get("pokemons.csv"));
        CSVWriter csvWriter = new CSVWriter(writer);
        
        scanner.close();
    }
}
