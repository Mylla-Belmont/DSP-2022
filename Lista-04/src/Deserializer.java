import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Deserializer {
    public static void main(String[] args) throws IOException{
        File file = new File("livros.xml");
        XmlMapper  xm = new XmlMapper();
        Livros p = xm.readValue(file, Livros.class);
        System.out.println(p);
    }
}