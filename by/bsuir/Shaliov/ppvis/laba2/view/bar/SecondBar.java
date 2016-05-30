package by.bsuir.Shaliov.ppvis.laba2.view.bar;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Andrey on 5/30/2016.
 */
public class SecondBar extends JToolBar {

    public SecondBar() {
        addBarPage();
    }

    private void addBarPage() {
        AbstractAction first = new AbstractAction("first", new ImageIcon("src\\resources\\first.png")) {
            public void actionPerformed(ActionEvent event) {

            }
        };
        AbstractAction prev = new AbstractAction("prev", new ImageIcon("src\\resources\\prev.png")) {
            public void actionPerformed(ActionEvent event) {

            }
        };
        AbstractAction next = new AbstractAction("next", new ImageIcon("src\\resources\\next.png")) {
            public void actionPerformed(ActionEvent event) {

            }
        };
        AbstractAction last = new AbstractAction("last", new ImageIcon("src\\resources\\last.png")) {
            public void actionPerformed(ActionEvent event) {

            }
        };



        add(first);
        add(prev);
//        secondBar.add(mainFrame.getPage());
        add(next);
        add(last);
    }

    private void addSlider() {

    }
}
