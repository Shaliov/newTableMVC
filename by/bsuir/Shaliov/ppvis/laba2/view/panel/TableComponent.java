package by.bsuir.Shaliov.ppvis.laba2.view.panel;


import by.bsuir.Shaliov.ppvis.laba2.model.TableModel;
import by.bsuir.Shaliov.ppvis.laba2.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba2.view.bar.SecondBar;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Andrey on 5/30/2016.
 */
public class TableComponent extends JPanel {

    private static TableComponent instance = null;
    private JScrollPane scrollPane;

    public static TableComponent getInstance() {
        if (instance == null) {
            instance = new TableComponent();
        }
        return instance;
    }

    private TableComponent() {
        TableModel tableModel = TableModel.getInstance();
        JTable table = new JTable(tableModel);
        Dimension dimension = new Dimension(100, 1000);
        table.setPreferredSize(dimension);
        scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.revalidate();
        add(scrollPane);
    }

    public TableComponent(java.util.List<Teacher> teacherList) {
        TableModel tableModel = new TableModel(teacherList);
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
