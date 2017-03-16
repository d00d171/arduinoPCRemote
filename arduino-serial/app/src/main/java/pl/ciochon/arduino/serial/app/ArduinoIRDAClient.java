package pl.ciochon.arduino.serial.app;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.ciochon.arduino.serial.support.spring.ApplicationConfiguration;

public class ArduinoIRDAClient {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    }

}