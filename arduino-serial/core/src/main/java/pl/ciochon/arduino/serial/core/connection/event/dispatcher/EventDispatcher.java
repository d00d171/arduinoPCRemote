package pl.ciochon.arduino.serial.core.connection.event.dispatcher;

/**
 * Created by Konrad Ciochoń on 2017-02-09.
 */
public interface EventDispatcher {

    public void dispatch(String eventValue);

}
