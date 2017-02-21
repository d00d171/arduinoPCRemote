package pl.ciochon.arduino.serial.lcdWriter;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Konrad Ciochoń on 2017-02-12.
 */
public interface LcdScreenController {

    void write(byte[] data);

    void printTemporary(byte[] data);

}
