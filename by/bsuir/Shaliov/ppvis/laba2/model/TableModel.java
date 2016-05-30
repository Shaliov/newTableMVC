package by.bsuir.Shaliov.ppvis.laba2.model;

import by.bsuir.Shaliov.ppvis.laba2.storage.DBStorage;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 5/30/2016.
 */
public class TableModel extends AbstractTableModel {

    private DBStorage dbStorage = DBStorage.getInstance();
    private List<Teacher> teacherList = dbStorage.getTeacherList() ;
    public static final int column = 5;
    public static final String columnNames[] = {
            "Факультет",
            "Название кафедры",
            "ФИО преподавателя",
            "ученое звание",
            "ученая степень"
    };

    public TableModel() {

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