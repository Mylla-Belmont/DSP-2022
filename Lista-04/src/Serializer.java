import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Serializer {
    public static void main(String[] args) throws IOException{
        
        Pessoa pessoa1 = new Pessoa(1, "Biriba", "biriba_chan@gmail.com", 8586);
        Pessoa pessoa2 = new Pessoa(2, "Biribão", "biribão_chan@gmail.com", 858697);
        Pessoa pessoa3 = new Pessoa(3, "Biribinha", "biribinha_chan@gmail.com", 85869748);
        Pessoa pessoa4 = new Pessoa(4, "Biribinham", "biribinham_chan@gmail.com", 858697482);

        List<Pessoa> lista = new ArrayList<Pessoa>();
        lista.add(pessoa1);
        lista.add(pessoa2);
        lista.add(pessoa3);
        lista.add(pessoa4);
        Pessoas pessoas = new Pessoas(lista);

        File file = new File("pessoas.xml");
        XmlMapper xm = new XmlMapper();
        xm.enable(SerializationFeature.INDENT_OUTPUT);
        xm.writeValue(file, pessoas);
    }
}