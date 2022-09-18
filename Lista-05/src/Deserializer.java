import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Deserializer {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper =  new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Livros livros = mapper.readValue(new File("livros.json"), Livros.class);
        System.out.println(livros.toString());
    }
}
