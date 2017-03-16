package pl.ciochon.arduino.serial.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.ciochon.arduino.serial.pilot.KeysMapping;

import java.io.File;
import java.io.IOException;

/**
 * Created by Konrad Ciochoń on 2017-02-08.
 */
public class TestClass {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        TestClass testClass = new TestClass();

        try {
            KeysMapping appConfiguration = objectMapper.readValue(new File(testClass.getClass().getClassLoader().getResource("app.properties").getFile()), KeysMapping.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(System.getProperty("nirCmd.path"));

        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(5000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();

        try {
//            Runtime.getRuntime().exec("cmd /c start shutdown -s -t 3600");
            Runtime.getRuntime().exec("cmd /c start " + System.getProperty("nirCmd.path") + " changesysvolume -65000");
        } catch (IOException e) {
            System.out.println("exception" + e);
        }
    }


}
