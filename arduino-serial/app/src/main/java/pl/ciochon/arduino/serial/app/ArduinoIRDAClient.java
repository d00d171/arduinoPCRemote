package pl.ciochon.arduino.serial.app;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.ciochon.arduino.serial.support.spring.ApplicationConfiguration;

public class ArduinoIRDAClient {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(500000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

}