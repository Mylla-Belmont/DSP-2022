import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class deserialize {
    public static void main(String [] args) throws IOException {

        Pessoa p = null;
        
        try {
            FileInputStream fileIn = new FileInputStream("C:\\Users\\Camila\\Documents\\GitHub\\DSP-2022-1\\Lista-03\\src\\out.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p = (Pessoa) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserializado");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(p);
    }
}
