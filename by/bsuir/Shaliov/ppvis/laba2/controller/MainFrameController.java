package by.bsuir.Shaliov.ppvis.laba2.controller;

import by.bsuir.Shaliov.ppvis.laba2.view.dialog.AddDialog;
import by.bsuir.Shaliov.ppvis.laba2.view.dialog.DeleteDialog;
import by.bsuir.Shaliov.ppvis.laba2.view.dialog.FindDialog;
import by.bsuir.Shaliov.ppvis.laba2.view.frame.MainFrame;
import by.bsuir.Shaliov.ppvis.laba2.view.panel.TableComponent;

import javax.swing.*;
import java.util.Base64;

/**
 * Created by Andrey on 5/31/2016.
 */
public class MainFrameController {
    private static MainFrameController instance = null;
    private MainFrame mainFrame;
    private AddDialog addDialog;
    private DeleteDialog deleteDialog;
    private FindDialog findDialog;

    private MainFrameController() {
    }

    public void newAddDialog() {
        if (addDialog == null) {
            addDialog = new AddDialog();
        }
        addDialog.setVisible(true);
    }

    public void newFindDealog() {
        if(findDialog == null) {
            findDialog = new FindDialog();
        }
        findDialog.setVisible(true);
    }

    public void newDeleteDialog() {
        if(deleteDialog == null) {
            deleteDialog = new DeleteDialog();
        }
        deleteDialog.setVisible(true);
    }

    public void refresh() {
        TableComponent.getInstance().getScrollPane().repaint();
        TableComponent.getInstance().revalidate();
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
