package by.bsuir.Shaliov.ppvis.laba2.controller;

import by.bsuir.Shaliov.ppvis.laba2.view.dialog.AddDialog;
import by.bsuir.Shaliov.ppvis.laba2.view.frame.MainFrame;

import java.util.Base64;

/**
 * Created by Andrey on 5/31/2016.
 */
public class MainFrameController {
    private static MainFrameController instance = null;
    private MainFrame mainFrame;
    private AddDialog addDialog;

    private MainFrameController() {
    }

    public void newAddDialog() {
        if (addDialog == null) {
            addDialog = new AddDialog();
        }
        addDialog.setVisible(true);
    }

    public void refresh() {
        mainFrame.repaint();
    }


    public static MainFrameController getInstance() {
        if (instance == null) {
            instance = new MainFrameController();
        }
        return instance;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}
