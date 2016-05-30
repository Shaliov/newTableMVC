package by.bsuir.Shaliov.ppvis.laba2.storage;

import by.bsuir.Shaliov.ppvis.laba2.model.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 5/30/2016.
 */
public class DBStorage {
    private static DBStorage instance = null;
    private List<Teacher> teacherList = new ArrayList<>();

    public DBStorage() {

    }

    public DBStorage(DBStorage dbStorage) {
        instance = dbStorage;
    }

    public void add(Teacher teacher) {
        teacherList.add(teacher);
    }




    public static DBStorage getInstance() {
        if (instance == null) {
            instance = new DBStorage();
        }
        return instance;
    }

    public static void setInstance(DBStorage instance) {
        DBStorage.instance = instance;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}
