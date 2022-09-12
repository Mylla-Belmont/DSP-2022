import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Deserializer {
    public static void main(String[] args) throws IOException{
        File file = new File("pessoas.xml");
        XmlMapper  xm = new XmlMapper();
        Pessoas p = xm.readValue(file, Pessoas.class);
        System.out.println(p);
    }
}