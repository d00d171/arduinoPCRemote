package pl.ciochon.arduino.serial.core.connection;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by Konrad Ciochoń on 2017-02-12.
 */
public class SerialWriter {

    Connection connection;

    public void write(byte[] data){
        try {
            connection.getOutput().write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
