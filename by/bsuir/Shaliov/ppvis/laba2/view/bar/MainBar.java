package by.bsuir.Shaliov.ppvis.laba2.view.bar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrey on 5/30/2016.
 */
public class MainBar extends JToolBar {

    public MainBar() {
        addBarMain(this);
    }
    private void addBarMain(JToolBar bar) {
        AbstractAction newEntry = new AbstractAction("new entry ", new ImageIcon("src\\resources\\add.png")) {
            public void actionPerformed(ActionEvent event) {

            System.out.println("asd");
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
