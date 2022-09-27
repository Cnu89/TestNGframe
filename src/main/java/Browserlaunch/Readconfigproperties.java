package Browserlaunch;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readconfigproperties {
    public static String Fetchproperties(String key) throws IOException {
        FileInputStream fs= new FileInputStream("src/Config/App.properties");
        Properties pr=new Properties();
        pr.load(fs);
        return (pr.get(key)).toString();
    }

}
