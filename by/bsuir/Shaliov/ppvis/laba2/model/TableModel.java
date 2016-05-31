package by.bsuir.Shaliov.ppvis.laba2.model;

import by.bsuir.Shaliov.ppvis.laba2.controller.TableController;
import by.bsuir.Shaliov.ppvis.laba2.enumeration.ColumnNames;
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
    private List<Teacher> teacherList = dbStorage.getTeacherList() ;
    public static final int column = 5;


    private TableModel() {
    }

    public TableModel(List<Teacher> teachers) {
        teacherList = teachers;
    }

    public static final String columnNames[] = {
            ColumnNames.FACULTY.getName(),
            ColumnNames.DEPARTMENT_NAME.getName(),
            ColumnNames.FIO.getName(),
            ColumnNames.ACADEMIC_TITLE.getName(),
            ColumnNames.ACADEMIC_DEGREE.getName()
    };


    public static TableModel getInstance() {
        if(instance == null) {
            instance = new TableModel();
        }
        return instance;
    }

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