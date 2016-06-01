package by.bsuir.Shaliov.ppvis.laba2.view.bar;

import by.bsuir.Shaliov.ppvis.laba2.controller.SecondBarController;
import by.bsuir.Shaliov.ppvis.laba2.controller.TableController;
import by.bsuir.Shaliov.ppvis.laba2.model.TableModel;
import by.bsuir.Shaliov.ppvis.laba2.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba2.storage.DBStorage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by Andrey on 5/30/2016.
 */
public class SecondBar extends JToolBar {

    private int numberOfPage = 1;
    private int lastPage;
    private JLabel page;
    private JLabel sliderMark;
    private JSlider slider;
    private SecondBarController secondBarController = SecondBarController.getInstance();
    private DBStorage dbStorage = DBStorage.getInstance();

    public SecondBar() {
        addBarPage();
        addSlider();
    }

    public void addBarPage() {
        AbstractAction first = new AbstractAction("first", new ImageIcon("src\\resources\\first.png")) {
            public void actionPerformed(ActionEvent event) {
                numberOfPage = 1;
                page.setText(String.valueOf(numberOfPage));
                secondBarController.changeNumberOfPage();

            }
        };
        AbstractAction prev = new AbstractAction("prev", new ImageIcon("src\\resources\\prev.png")) {
            public void actionPerformed(ActionEvent event) {
                if (numberOfPage > 1) {
                    numberOfPage = numberOfPage - 1;
                    page.setText(String.valueOf(numberOfPage));

                    secondBarController.changeNumberOfPage(dbStorage.getTeacherList(secondBarController.getRowOnPage() * numberOfPage - secondBarController.getRowOnPage(),
                            secondBarController.getRowOnPage() * numberOfPage));
                }

            }
        };
        AbstractAction next = new AbstractAction("next", new ImageIcon("src\\resources\\next.png")) {
            public void actionPerformed(ActionEvent event) {
                if (DBStorage.getInstance().getTeacherList().size() % secondBarController.getRowOnPage() != 0) {
                    lastPage = (int) Math.round((double) (DBStorage.getInstance().getTeacherList().size() % secondBarController.getRowOnPage())) + 1;
                    if (numberOfPage < lastPage) {
                        numberOfPage = numberOfPage + 1;
                        page.setText(String.valueOf(numberOfPage));
                        secondBarController.changeNumberOfPage(dbStorage.getTeacherList(secondBarController.getRowOnPage() * numberOfPage - secondBarController.getRowOnPage(),
                                secondBarController.getRowOnPage() * numberOfPage));

                    }
                } else {
                    lastPage = (int) Math.round((double) (DBStorage.getInstance().getTeacherList().size() % secondBarController.getRowOnPage()));
                    if (numberOfPage + 1 == lastPage) {
                        numberOfPage = lastPage;
                        page.setText(String.valueOf(numberOfPage));
                        secondBarController.changeNumberOfPage(dbStorage.getTeacherList(dbStorage.getTeacherList().size() - secondBarController.getRowOnPage(),
                                dbStorage.getTeacherList().size()));
                    } else if (numberOfPage < lastPage) {
                        numberOfPage = numberOfPage + 1;
                        page.setText(String.valueOf(numberOfPage));
                        secondBarController.changeNumberOfPage(dbStorage.getTeacherList(secondBarController.getRowOnPage() * numberOfPage - secondBarController.getRowOnPage(),
                                secondBarController.getRowOnPage() * numberOfPage));

                    }
                }

            }
        };
        AbstractAction last = new AbstractAction("last", new ImageIcon("src\\resources\\last.png")) {
            public void actionPerformed(ActionEvent event) {
                if (DBStorage.getInstance().getTeacherList().size() % secondBarController.getRowOnPage() == 0) {
                    lastPage = (int) Math.round((double) (DBStorage.getInstance().getTeacherList().size() % secondBarController.getRowOnPage())) + 1;
                    numberOfPage = lastPage;
                    secondBarController.changeNumberOfPage(dbStorage.getTeacherList(dbStorage.getTeacherList().size() - secondBarController.getRowOnPage(),
                            dbStorage.getTeacherList().size()));
                } else {
                    lastPage = (int) Math.round((double) (DBStorage.getInstance().getTeacherList().size() % secondBarController.getRowOnPage()));
                    numberOfPage = lastPage;
                    secondBarController.changeNumberOfPage(dbStorage.getTeacherList(secondBarController.getRowOnPage() * numberOfPage - secondBarController.getRowOnPage(),
                            dbStorage.getTeacherList().size()));
                }
                page.setText(String.valueOf(numberOfPage));


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
        slider = new JSlider(1, 50, 10);
        slider.setSnapToTicks(true);
        sliderMark = new JLabel(String.valueOf(10));
        slider.addChangeListener(secondBarController.addSlideListener());

        secondBarController.setSlider(slider);
        secondBarController.setSliderMark(sliderMark);
        secondBarController.setRowOnPage(10);
        add(slider);
        add(sliderMark);
    }
}
