import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserializer {
    public static void main(String[] args) throws IOException {

        
        BufferedReader br = new BufferedReader(new FileReader("livros.json"));
        Livro livro =  new ObjectMapper().readValue(br, Livro.class);
        System.out.println(livro);
        br.close();

        // File file = new File("livros.json"); 

        // Livro livro = new ObjectMapper().readValue(file, Livro.class);

        // System.out.println(livro);
    }
}
