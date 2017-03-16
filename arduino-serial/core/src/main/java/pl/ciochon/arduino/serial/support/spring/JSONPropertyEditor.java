package pl.ciochon.arduino.serial.support.spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Konrad Ciochoń on 2017-03-16.
 */
public class JSONPropertyEditor extends PropertyEditorSupport {

    Logger logger = Logger.getLogger(JSONPropertyEditor.class);

    @Override
    public String getAsText() {
        Object object = getValue();
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("Error reading value", e);
            return null;
        }
    }

    @Override
    public void setAsText(String text) {
        try {
            setValue(new ObjectMapper().readValue(text, Map.class));
        } catch (IOException e) {
            logger.error("Error setting value", e);
        }
    }
}