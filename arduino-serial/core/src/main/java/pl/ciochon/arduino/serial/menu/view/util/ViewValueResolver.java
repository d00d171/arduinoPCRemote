package pl.ciochon.arduino.serial.menu.view.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by Konrad Ciochoń on 2017-02-24.
 */
public class ViewValueResolver {

    Logger logger = Logger.getLogger(ViewValueResolver.class);

    private String language;

    private ResourceBundle messages;

    private Properties properties;

    @Value("${lang.version}")
    public void setLanguage(String language) {
        this.language = language;
        Locale locale = new Locale(language);
        messages = ResourceBundle.getBundle("messages", locale);
    }

    public String getViewValue(String key) {
        try {
            String result = (String) messages.getString(key);
            if (result == null) {
                return "!!!" + key + "!!!";
            }
            return new String(result.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("Error returning view value", e);
            return "!!!" + key + "!!!";
        }
    }

}
