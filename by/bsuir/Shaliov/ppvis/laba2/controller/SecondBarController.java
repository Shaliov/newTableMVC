package by.bsuir.Shaliov.ppvis.laba2.controller;

import by.bsuir.Shaliov.ppvis.laba2.model.TableModel;
import by.bsuir.Shaliov.ppvis.laba2.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba2.storage.DBStorage;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.util.List;

/**
 * Created by Andrey on 5/31/2016.
 */
public class SecondBarController {
    private static SecondBarController instance = null;
    private JSlider slider;
    private JLabel sliderMark;
    private int rowOnPage;
    private int numberOfPage = 1;
    private int lastPage;
    private TableModel tableModel;


    private SecondBarController() {
    }


    public static SecondBarController getInstance() {
        if (instance == null) {
            instance = new SecondBarController();
        }
        return instance;
    }

    public ChangeListener addSlideListener() {
        return e -> {
            slider = (JSlider) e.getSource();
            if (!slider.getValueIsAdjusting()) {
                rowOnPage = slider.getValue();
                sliderMark.setText(String.valueOf(rowOnPage));
                SecondBarController.this.setNumberOfPage(1);
                TableController.getInstance().firstPage();
            }
        };
    }

    public void changeNumberOfPage() {
        if (rowOnPage < DBStorage.getInstance().getTeacherList().size()) {
            tableModel.setTeacherList(DBStorage.getInstance().getTeacherList(0, rowOnPage));
        } else {
            tableModel.setTeacherList(DBStorage.getInstance().getTeacherList());
        }
        TableController.getInstance().refresh();
    }

    public void changeNumberOfPage(List<Teacher> teachers) {
        tableModel.setTeacherList(teachers);
        TableController.getInstance().refresh();
    }

    public JSlider getSlider() {
        return slider;
    }

    public JLabel getSliderMark() {
        return sliderMark;
    }

    public int getRowOnPage() {
        return rowOnPage;
    }

    public void setSlider(JSlider slider) {
        this.slider = slider;
    }

    public void setSliderMark(JLabel sliderMark) {
        this.sliderMark = sliderMark;
    }

    public void setRowOnPage(int rowOnPage) {
        this.rowOnPage = rowOnPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public TableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }
}


