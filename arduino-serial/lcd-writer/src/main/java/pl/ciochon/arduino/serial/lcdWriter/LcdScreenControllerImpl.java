package pl.ciochon.arduino.serial.lcdWriter;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.connection.SerialWriter;

/**
 * Created by Konrad Ciochoń on 2017-02-12.
 */
public class LcdScreenControllerImpl implements LcdScreenController{

    private LcdSerialWriter lcdSerialWriter;

    private SerialWriter serialWriter;

    public void write(byte[] data){
        lcdSerialWriter.write(data);
    }

    public void printTemporary(byte[] data) {
        //TODO
    }

    @Autowired
    public void setLcdSerialWriter(LcdSerialWriter lcdSerialWriter) {
        this.lcdSerialWriter = lcdSerialWriter;
    }

    @Autowired
    public void setSerialWriter(SerialWriter serialWriter) {
        this.serialWriter = serialWriter;
    }
}
