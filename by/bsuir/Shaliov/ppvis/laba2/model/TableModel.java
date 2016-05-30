package by.bsuir.Shaliov.ppvis.laba2.model;

import by.bsuir.Shaliov.ppvis.laba2.storage.DBStorage;
import by.bsuir.Shaliov.ppvis.laba2.view.dialog.AddDialog;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Andrey on 5/30/2016.
 */
public class TableModel extends AbstractTableModel {
    private static TableModel instance = null;
    private DBStorage dbStorage = DBStorage.getInstance();
    //в dbStorage seteacherlist быть не должно, иначе мы не можем гарантировать что здесь и там - один и тот же список
    private List<Teacher> teacherList = dbStorage.getTeacherList() ;
    public static final int column = 5;


    public TableModel() {

    }

    public TableModel(TableModel tableModel) {
        instance = tableModel;
    }


    // зачем если конструкторы public
    public static TableModel getInstance() {
        if (instance == null) {
            instance = new TableModel();
        }
        return instance;
    }

    // а это что за чудо
    public static void setInstance(TableModel instance) {
        TableModel.instance = instance;
    }

    public static final String columnNames[] = {
            "Факультет",
            "Название кафедры",
            "ФИО преподавателя",
            "ученое звание",
            "ученая степень"
    };



    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    @Override
    public int getRowCount() {
        return teacherList.size();
    }
    @Override
    public int getColumnCount() {
        return column;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Teacher teacher = teacherList.get(rowIndex);
        return teacher.get(columnIndex);
    }
    public static final String[] getColumnNames() {
        return columnNames;
    }

}