package by.bsuir.Shaliov.ppvis.laba2.view.panel;


import by.bsuir.Shaliov.ppvis.laba2.model.TableModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Andrey on 5/30/2016.
 */
public class TableComponent extends JPanel {

    JScrollPane scrollPane;

    public TableComponent() {
        TableModel tableModel = new TableModel();
        JTable table = new JTable(tableModel);
        Dimension dimension = new Dimension(100, 1000);
        table.setPreferredSize(dimension);
        scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.revalidate();
        add(scrollPane);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}
