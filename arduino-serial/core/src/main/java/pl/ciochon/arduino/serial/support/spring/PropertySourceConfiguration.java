package pl.ciochon.arduino.serial.support.spring;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Konrad Ciochoń on 2017-02-11.
 */
@PropertySource("classpath:config.properties")
public class PropertySourceConfiguration {

    @Bean
    public JSONPropertyEditor jsonPropertyEditor() {
        return new JSONPropertyEditor();
    }

    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        Map<Class<?>, Class<? extends PropertyEditor>> propertyEditorSupportMap = new HashMap<>();
        propertyEditorSupportMap.put(Map.class, JSONPropertyEditor.class);
        customEditorConfigurer.setCustomEditors(propertyEditorSupportMap);
        return customEditorConfigurer;
    }
}
