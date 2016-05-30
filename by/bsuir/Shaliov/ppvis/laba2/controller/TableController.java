package by.bsuir.Shaliov.ppvis.laba2.controller;


import by.bsuir.Shaliov.ppvis.laba2.model.TableModel;

/**
 * Created by Andrey on 5/31/2016.
 */
public class TableController {
    private static TableController instance = null;
    private TableModel tableModel = TableModel.getInstance();

    public TableController() {

    }

    public TableController(TableController tableController) {
        instance = tableController;
    }



    public void refresh() {
        tableModel.fireTableDataChanged();
    }







    public static TableController getInstance() {
        if (instance == null) {
            instance = new TableController();
        }
        return instance;
    }

    public static void setInstance(TableController instance) {
        TableController.instance = instance;
    }
}
