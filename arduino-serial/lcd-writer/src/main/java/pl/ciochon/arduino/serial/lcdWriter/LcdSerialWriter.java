package pl.ciochon.arduino.serial.lcdWriter;

import pl.ciochon.arduino.serial.core.connection.SerialWriter;
import pl.ciochon.arduino.serial.core.exception.LcdWriteException;
import pl.ciochon.arduino.serial.lcdWriter.util.LcdSerialWriterUtil;

/**
 * Created by Konrad Ciochoń on 2017-02-12.
 */
public class LcdSerialWriter extends SerialWriter {

    @Override
    public void write(byte[] data) {
        if(data.length != 32){
            throw new LcdWriteException("Incorrect data length: " + data.length + ", required: 32" );
        }
        super.write(data);
    }

    public void write(String line1In, String line2In){
        String line1 = line1In.length() != 16 ? LcdSerialWriterUtil.suffixLine(line1In, " ") : line1In;
        String line2 = line2In.length() != 16 ? LcdSerialWriterUtil.suffixLine(line2In, " ") : line2In;

        byte[] line1Data  = line1.getBytes();
        byte[] line2Data = line2.getBytes();
        byte[] data = new byte[line1.length() + line2.length()];

        System.arraycopy(line1Data, 0, data, 0, line1Data.length);
        System.arraycopy(line2Data, 0, data, line1Data.length, line2Data.length);

        write(data);
    }

}
