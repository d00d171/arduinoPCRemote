package pl.ciochon.arduino.serial.core.connection;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.core.connection.event.dispatcher.EventDispatcher;

import java.io.BufferedReader;

public class SerialListener implements SerialPortEventListener{

    private BufferedReader input;
    private EventDispatcher eventDispatcher;

    public void serialEvent(SerialPortEvent serialPortEvent) {
        if (serialPortEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputValue = input.readLine();
                System.out.println(inputValue);
                eventDispatcher.dispatch(inputValue);
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
    }

    @Autowired
    public void setEventDispatcher(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public void setInput(BufferedReader input) {
        this.input = input;
    }
}
