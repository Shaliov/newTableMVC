package by.bsuir.Shaliov.ppvis.laba2.view.bar;

import by.bsuir.Shaliov.ppvis.laba2.controller.MainFrameController;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Andrey on 5/30/2016.
 */
public class MainBar extends JToolBar {
    private MainFrameController mainFrameController = MainFrameController.getInstance();

    public MainBar() {
        addBarMain(this);
    }
    private void addBarMain(JToolBar bar) {
        AbstractAction newEntry = new AbstractAction("new entry ", new ImageIcon("src\\resources\\add.png")) {
            public void actionPerformed(ActionEvent event) {
                mainFrameController.newAddDialog();
            }
        };
        AbstractAction deleteEntry = new AbstractAction("delete entry", new ImageIcon("src\\resources\\remove.png")) {
            public void actionPerformed(ActionEvent event) {


            }
        };
        AbstractAction findEntry = new AbstractAction("find entry", new ImageIcon("src\\resources\\search.png")) {
            public void actionPerformed(ActionEvent event) {

            }
        };
        bar.add(newEntry);
        bar.add(deleteEntry);
        bar.add(findEntry);
    }
}
