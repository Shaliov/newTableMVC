package by.bsuir.Shaliov.ppvis.laba2.view.bar;

import by.bsuir.Shaliov.ppvis.laba2.controller.SecondBarController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Andrey on 5/30/2016.
 */
public class SecondBar extends JToolBar {

    private int numberOfPage = 1;
    private int rowOnPage = 10;
    private JLabel page;
    private JLabel sliderMark;
    private JSlider slider;
    private SecondBarController secondBarController = SecondBarController.getInstance();


    public SecondBar() {
        addBarPage();
        addSlider();
    }

    public void addBarPage() {
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

        page = new JLabel(String.valueOf(numberOfPage));
        page.setPreferredSize(new Dimension(23, 50));
        page.setHorizontalAlignment(JLabel.CENTER);

        add(first);
        add(prev);
        add(page);
        add(next);
        add(last);
    }

    private void addSlider() {
        slider = new JSlider(1, 50, rowOnPage);
        slider.setSnapToTicks(true);
        sliderMark = new JLabel(String.valueOf(rowOnPage));
        slider.addChangeListener(secondBarController.addSlideListener());

        secondBarController.setSlider(slider);
        secondBarController.setSliderMark(sliderMark);
        secondBarController.setRowOnPage(rowOnPage);
        add(slider);
        add(sliderMark);
    }
}
