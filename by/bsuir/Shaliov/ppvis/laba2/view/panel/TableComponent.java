package by.bsuir.Shaliov.ppvis.laba2.view.panel;


import by.bsuir.Shaliov.ppvis.laba2.controller.SecondBarController;
import by.bsuir.Shaliov.ppvis.laba2.controller.TableController;
import by.bsuir.Shaliov.ppvis.laba2.model.TableModel;
import by.bsuir.Shaliov.ppvis.laba2.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba2.storage.DBStorage;
import by.bsuir.Shaliov.ppvis.laba2.view.bar.SecondBar;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Andrey on 5/30/2016.
 */
public class TableComponent extends JPanel {

    private JScrollPane scrollPane;
    private TableModel tableModel;

    public TableComponent() {
        tableModel = new TableModel();
        SecondBarController.getInstance().setTableModel(tableModel);
        tableModel.setTeacherList(DBStorage.getInstance().getTeacherList());
        tableModel.setTempList(DBStorage.getInstance().getTeacherList());
        TableController.getInstance().setTableModel(tableModel);
        JTable table = new JTable(tableModel);
        Dimension dimension = new Dimension(100, 1000);
        table.setPreferredSize(dimension);
        scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.revalidate();
        add(scrollPane);
    }

    public TableComponent(java.util.List<Teacher> teacherList) {
        tableModel = new TableModel(teacherList);
        tableModel.setTeacherList(teacherList);
        SecondBarController.getInstance().setTableModel(tableModel);
        TableController.getInstance().setTableModel(tableModel);
        JTable table = new JTable(tableModel);
        Dimension dimension = new Dimension(100, 1000);
        table.setPreferredSize(dimension);
        scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.revalidate();
        add(scrollPane);
    }


    public TableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

}
