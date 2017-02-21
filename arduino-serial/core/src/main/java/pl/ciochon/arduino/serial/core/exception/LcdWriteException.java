package pl.ciochon.arduino.serial.core.exception;

/**
 * Created by Konrad Ciochoń on 2017-02-12.
 */
public class LcdWriteException extends RuntimeException{

    public LcdWriteException(String message) {
        super(message);
    }

}
