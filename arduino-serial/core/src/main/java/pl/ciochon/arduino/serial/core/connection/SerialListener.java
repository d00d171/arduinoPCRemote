package pl.ciochon.arduino.serial.core.connection;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.connection.event.dispatcher.EventDispatcher;

import java.io.BufferedReader;

public class SerialListener implements SerialPortEventListener {

    private static final Logger logger = Logger.getLogger(SerialListener.class);

    private BufferedReader input;

    @Autowired
    private EventDispatcher eventDispatcher;

    public void serialEvent(SerialPortEvent serialPortEvent) {
        if (serialPortEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputValue = input.readLine();
                logger.trace("Read line: " + inputValue);
                eventDispatcher.dispatch(inputValue);
            } catch (Exception e) {
                logger.trace("Error reading serial", e);
            }
        }
    }

    public void setInput(BufferedReader input) {
        this.input = input;
    }
}
