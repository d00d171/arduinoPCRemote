package pl.ciochon.arduino.serial.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * Created by Konrad Ciochoń on 2017-03-01.
 */
public class AppConfigurationHolder {

    private static Logger logger = Logger.getLogger(AppConfigurationHolder.class);

    private AppConfiguration appConfiguration;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        try {
            appConfiguration = objectMapper.readValue(new File(this.getClass().getClassLoader().getResource("app.properties").getFile()), AppConfiguration.class);
        } catch (IOException e) {
            logger.error("Error reading app.properties file", e);
        }
    }

    public AppConfiguration getAppConfiguration() {
        return appConfiguration;
    }
}
