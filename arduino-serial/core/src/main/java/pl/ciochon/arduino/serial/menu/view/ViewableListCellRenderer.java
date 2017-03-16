package pl.ciochon.arduino.serial.menu.view;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ciochon.arduino.serial.menu.view.util.ViewValueResolver;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Konrad Ciochoń on 2017-02-24.
 */
public class ViewableListCellRenderer implements ListCellRenderer<Viewable> {

    @Autowired
    private ViewValueResolver viewValueResolver;

    @Override
    public Component getListCellRendererComponent(JList<? extends Viewable> list, Viewable value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel jLabel = new JLabel();
        jLabel.setText(viewValueResolver.getViewValue(value.getViewValueKey()));
        jLabel.setFont(list.getFont());
        if (isSelected) {
            jLabel.setOpaque(true);
        }
        return jLabel;
    }
}
