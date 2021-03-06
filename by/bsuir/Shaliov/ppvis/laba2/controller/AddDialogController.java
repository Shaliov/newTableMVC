package by.bsuir.Shaliov.ppvis.laba2.controller;

import by.bsuir.Shaliov.ppvis.laba2.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba2.storage.DBStorage;
import by.bsuir.Shaliov.ppvis.laba2.view.panel.TableComponent;

/**
 * Created by Andrey on 5/31/2016.
 */
public class AddDialogController {
    private static AddDialogController instance = null;
    private DBStorage dbStorage = DBStorage.getInstance();
    private TableController tableController = TableController.getInstance();
    private MainFrameController mainFrameController = MainFrameController.getInstance();
    private TableComponent tableComponent;


    private AddDialogController() {
    }

    public void addTeacherToDB(Object faculty, Object departmentName, String name, String secondaryName,
                               String middleName, Object academicTitle, Object academicDegree) {
        dbStorage.add(new Teacher(faculty, departmentName, name, secondaryName, middleName, academicTitle, academicDegree));
        tableController.refresh();
        mainFrameController.refresh(tableComponent);
    }

    public void setTableComponent(TableComponent tableComponent) {
        this.tableComponent = tableComponent;
    }

    public static AddDialogController getInstance() {
        if (instance == null) {
            instance = new AddDialogController();
        }
        return instance;
    }

}
