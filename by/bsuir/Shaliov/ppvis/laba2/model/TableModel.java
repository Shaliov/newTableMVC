package by.bsuir.Shaliov.ppvis.laba2.model;

import by.bsuir.Shaliov.ppvis.laba2.enumeration.ColumnNames;
import by.bsuir.Shaliov.ppvis.laba2.storage.DBStorage;
import com.sun.javafx.charts.Legend;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 5/30/2016.
 */
public class TableModel extends AbstractTableModel {
    private static TableModel instance = null;
    private DBStorage dbStorage = DBStorage.getInstance();
    private List<Teacher> teacherList = dbStorage.getTeacherList() ;
    private List<Teacher> tempList  = dbStorage.getTeacherList() ;
    public static final int column = 5;

    public List<Teacher> getTempList() {
        return tempList;
    }

    public void setTempList(List<Teacher> tempList) {
        this.tempList = tempList;
    }

    private TableModel() {
    }

    public TableModel(List<Teacher> teachers) {
        instance = getInstance();
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

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public List<Teacher> getTempList(int startIndex, int endIndex) {
        List<Teacher> result = new ArrayList<>();
        for(int i = startIndex; i < endIndex; i++) {
            result.add(dbStorage.getTeacherList().get(i));
        }
        return result;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}