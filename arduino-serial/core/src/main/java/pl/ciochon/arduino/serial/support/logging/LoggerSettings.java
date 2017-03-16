package pl.ciochon.arduino.serial.support.logging;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Konrad Ciochoń on 2017-03-16.
 */
public class LoggerSettings {

    @Value("${logging.level:INFO}")
    public void setLogging(String logging) {
        Logger.getRootLogger().setLevel(Level.toLevel(logging, Level.OFF));
    }

}
