import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializer {
    public static void main(String[] args) throws JsonProcessingException {
        
        Livro livro1 = new Livro(0001, "Livro_terror", "Terror");
        Livro livro3 = new Livro(0002, "Livro_ficção", "Ficção");
        Livro livro2 = new Livro(0003, "Livro_romance", "Romance");
        Livro livro4 = new Livro(0004, "Livro_Didatico", "Didatico");

        List<Livro> lista = new ArrayList<Livro>();
        lista.add(livro1);
        lista.add(livro2);
        lista.add(livro3);
        lista.add(livro4);
        Livros livros = new Livros(lista);
        
        try {
            ObjectMapper jsonString = new ObjectMapper();
            jsonString.writerWithDefaultPrettyPrinter().writeValue(new File("livros.json"), livros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}