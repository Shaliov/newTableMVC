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

    private DBStorage() {

    }

    public void add(Teacher teacher) {
        teacherList.add(teacher);
    }

    public void clear() {
        teacherList.clear();
    }

    public static DBStorage getInstance() {
        if (instance == null) {
            instance = new DBStorage();
        }
        return instance;
    }


    public List<Teacher> getTeacherList() {
        return teacherList;
    }

}
