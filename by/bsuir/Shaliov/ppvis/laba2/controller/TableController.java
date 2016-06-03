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

    private TableController() {

    }

    public void refresh() {
        TableModel.getInstance().fireTableDataChanged();
    }


    public void firstPage() {
        SecondBarController.getInstance().setNumberOfPage(1);
        SecondBarController.getInstance().changeNumberOfPage();
    }

    public void lastPage() {
        int rowOnPage = SecondBarController.getInstance().getRowOnPage();
        int lastPage = SecondBarController.getInstance().getLastPage();

        if (DBStorage.getInstance().getTeacherList().size() % rowOnPage == 0) {
            SecondBarController.getInstance().setLastPage((int) Math.round((double) (DBStorage.getInstance().getTeacherList().size() / rowOnPage)));
            SecondBarController.getInstance().setNumberOfPage(SecondBarController.getInstance().getLastPage());
            SecondBarController.getInstance().changeNumberOfPage(TableModel.getInstance().getTempList((rowOnPage * SecondBarController.getInstance().getLastPage()) - rowOnPage,
                    TableModel.getInstance().getTempList().size()));
        } else {
            SecondBarController.getInstance().setLastPage((int) Math.round((double) (DBStorage.getInstance().getTeacherList().size() / rowOnPage) + 1));
            SecondBarController.getInstance().setNumberOfPage(SecondBarController.getInstance().getLastPage());
            SecondBarController.getInstance().changeNumberOfPage(TableModel.getInstance().getTempList(rowOnPage * (SecondBarController.getInstance().getLastPage() - 1),
                    TableModel.getInstance().getTempList().size()));
        }
    }

    public void prev() {
        if (SecondBarController.getInstance().getNumberOfPage() > 1) {
            SecondBarController.getInstance().setNumberOfPage(SecondBarController.getInstance().getNumberOfPage() - 1);
            int numberOfPage = SecondBarController.getInstance().getNumberOfPage();
            int rowOnPage = SecondBarController.getInstance().getRowOnPage();
            SecondBarController.getInstance().changeNumberOfPage(TableModel.getInstance().getTempList(rowOnPage * numberOfPage - rowOnPage,
                    rowOnPage * numberOfPage));
        }
    }

    public void next() {
        int numberOfPage = SecondBarController.getInstance().getNumberOfPage();
        int rowOnPage = SecondBarController.getInstance().getRowOnPage();

        if (DBStorage.getInstance().getTeacherList().size() % rowOnPage == 0) {
            SecondBarController.getInstance().setLastPage((int) Math.round((double) (TableModel.getInstance().getTempList().size() / rowOnPage)));
        }
        else {
            SecondBarController.getInstance().setLastPage((int) Math.round((double) (TableModel.getInstance().getTempList().size() / rowOnPage) + 1));
        }
        int lastPage = SecondBarController.getInstance().getLastPage();
        if (numberOfPage != lastPage) {
                SecondBarController.getInstance().setNumberOfPage(numberOfPage + 1);
            if(TableModel.getInstance().getTempList().size() % rowOnPage != 0 && numberOfPage + 1 == lastPage) {
                SecondBarController.getInstance().changeNumberOfPage(TableModel.getInstance().getTempList(rowOnPage * numberOfPage,
                        TableModel.getInstance().getTempList().size()));
            }
            else {
                SecondBarController.getInstance().changeNumberOfPage(TableModel.getInstance().getTempList(rowOnPage * numberOfPage,
                        rowOnPage * (numberOfPage + 1)));}
            }
         else if (numberOfPage == lastPage) {
            SecondBarController.getInstance().setNumberOfPage(lastPage);
            lastPage();
        }
    }

    public void clear() {
        List <Teacher> teacherList = new ArrayList<>();
        teacherList.clear();
        TableModel.getInstance().setTeacherList(teacherList);
        TableModel.getInstance().setTempList(teacherList);
        refresh();
    }

    public static TableController getInstance() {
        if (instance == null) {
            instance = new TableController();
        }
        return instance;
    }

}
