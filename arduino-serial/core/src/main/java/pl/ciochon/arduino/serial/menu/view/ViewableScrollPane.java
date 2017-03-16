package pl.ciochon.arduino.serial.menu.view;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

/**
 * Created by Konrad Ciochoń on 2017-02-24.
 */
public class ViewableScrollPane<T extends Viewable> {

    private JList list;

    private DefaultListModel model;

    private Object[] options;

    private JScrollPane view;

    public ViewableScrollPane(Viewable[] options, Font font, Optional<ListCellRenderer<Viewable>> listCellRenderer) {
        this.options = options;
        model = new DefaultListModel();
        list = new JList(model);
        for (Object obj : options) {
            model.addElement(obj);
        }
        view = new JScrollPane(list);
        if (listCellRenderer.isPresent()) {
            list.setCellRenderer(listCellRenderer.get());
        }
        list.setFont(font);
        list.setSelectedIndex(0);
    }

    public void scrollUp() {
        list.setSelectedIndex(list.getSelectedIndex() - 1);
    }

    public void scrollDown() {
        list.setSelectedIndex(list.getSelectedIndex() + 1);
    }

    public T getSelectedValue() {
        return (T) list.getSelectedValue();
    }

    public JScrollPane getView() {
        return view;
    }
}
