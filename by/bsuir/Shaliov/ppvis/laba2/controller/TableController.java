package by.bsuir.Shaliov.ppvis.laba2.controller;


import by.bsuir.Shaliov.ppvis.laba2.model.TableModel;
import by.bsuir.Shaliov.ppvis.laba2.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba2.storage.DBStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 5/31/2016.
 */
public class TableController {
    private static TableController instance = null;
    private TableModel tableModel;

    SecondBarController secondBarController = SecondBarController.getInstance();

    private TableController() {

    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }


    public void firstPage() {
        SecondBarController.getInstance().setNumberOfPage(1);
        SecondBarController.getInstance().changeNumberOfPage();
    }

    public void lastPage() {

        int rowOnPage = secondBarController.getRowOnPage();
        int lastPage = secondBarController.getLastPage();

        if (tableModel.getTempList().size() % rowOnPage == 0) {
            secondBarController.setLastPage((int) Math.round((double) (tableModel.getTempList().size() / rowOnPage)));
            secondBarController.setNumberOfPage(secondBarController.getLastPage());
            secondBarController.changeNumberOfPage(tableModel.getTempList((rowOnPage * secondBarController.getLastPage()) - rowOnPage,
                    tableModel.getTempList().size()));
        } else {
            secondBarController.setLastPage((int) Math.round((double) (tableModel.getTempList().size() / rowOnPage) + 1));
            secondBarController.setNumberOfPage(secondBarController.getLastPage());
            secondBarController.changeNumberOfPage(tableModel.getTempList(rowOnPage * (secondBarController.getLastPage() - 1),
                    tableModel.getTempList().size()));
        }
    }

    public void prev() {
        if (SecondBarController.getInstance().getNumberOfPage() > 1) {
            SecondBarController.getInstance().setNumberOfPage(SecondBarController.getInstance().getNumberOfPage() - 1);
            int numberOfPage = SecondBarController.getInstance().getNumberOfPage();
            int rowOnPage = SecondBarController.getInstance().getRowOnPage();
            SecondBarController.getInstance().changeNumberOfPage(tableModel.getTempList(rowOnPage * numberOfPage - rowOnPage,
                    rowOnPage * numberOfPage));
        }
    }

    public void next() {
        int numberOfPage = SecondBarController.getInstance().getNumberOfPage();
        int rowOnPage = SecondBarController.getInstance().getRowOnPage();

        if (DBStorage.getInstance().getTeacherList().size() % rowOnPage == 0) {
            SecondBarController.getInstance().setLastPage((int) Math.round((double) (tableModel.getTempList().size() / rowOnPage)));
        }
        else {
            SecondBarController.getInstance().setLastPage((int) Math.round((double) (tableModel.getTempList().size() / rowOnPage) + 1));
        }
        int lastPage = SecondBarController.getInstance().getLastPage();
        if (numberOfPage != lastPage) {
                SecondBarController.getInstance().setNumberOfPage(numberOfPage + 1);
            if(tableModel.getTempList().size() % rowOnPage != 0 && numberOfPage + 1 == lastPage) {
                SecondBarController.getInstance().changeNumberOfPage(tableModel.getTempList(rowOnPage * numberOfPage,
                        tableModel.getTempList().size()));
            }
            else {
                SecondBarController.getInstance().changeNumberOfPage(tableModel.getTempList(rowOnPage * numberOfPage,
                        rowOnPage * (numberOfPage + 1)));
            }
            }
         else if (numberOfPage == lastPage) {
            SecondBarController.getInstance().setNumberOfPage(lastPage);
            lastPage();
        }
    }

    public void clear() {
        List <Teacher> teacherList = new ArrayList<>();
        teacherList.clear();
        tableModel.setTeacherList(teacherList);
        refresh();
    }

    public static TableController getInstance() {
        if (instance == null) {
            instance = new TableController();
        }
        return instance;
    }

    public TableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }
}
