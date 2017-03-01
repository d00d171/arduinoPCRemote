package pl.ciochon.arduino.serial.menu.windows.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by Konrad Ciochoń on 2017-02-24.
 */
public class ViewValueResolver {

    private Properties properties;

    public ViewValueResolver() {
        //TODO ladowanie w zaleznosci od wersji jezykowej i ogolnie jakos ladniej
        try {
            InputStream stream = getClass().getClassLoader().getResourceAsStream("messages_pl.properties");
            InputStreamReader isr = new InputStreamReader(stream, "UTF-8");
            properties = new Properties();
            properties.load(isr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getViewValue(String key) {
        String result = (String) properties.get(key);
        return result != null ? result : "!!!" + key + "!!!";
    }

}
