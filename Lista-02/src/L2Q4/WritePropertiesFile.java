package L2Q4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WritePropertiesFile {
    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        prop.setProperty("database", "localhost");
        prop.setProperty("dbuser", "camila");
        prop.setProperty("dbpassword", "creepypasta");
        prop.store(new FileOutputStream("config.properties"), null);
    }
}
