import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializer {
    public static void main(String[] args) throws IOException{
        
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        pessoa.setName("Biribinha");
        pessoa.setEmail("biribinha_chan@gmail.com");
        pessoa.setNumber(85869748);

        try {
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Camila\\Documents\\GitHub\\DSP-2022-1\\Lista-03\\src\\out.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(pessoa);
            out.close();
            System.out.println("Serializado");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
