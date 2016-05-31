package by.bsuir.Shaliov.ppvis.laba2.controller;

import by.bsuir.Shaliov.ppvis.laba2.model.Teacher;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Andrey on 5/31/2016.
 */
public class SecondBarController {
    private static SecondBarController instance = null;
    private JSlider slider;
    private JLabel sliderMark;
    private int rowOnPage;


    private SecondBarController() {
    }

    public static SecondBarController getInstance() {
        if (instance == null) {
            instance = new SecondBarController();
        }
        return instance;
    }

    public SliderListener addSlideListener() {
        return new SliderListener();
    }

    class SliderListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            slider = (JSlider) e.getSource();
            if (!slider.getValueIsAdjusting()) {
                rowOnPage = slider.getValue();
                sliderMark.setText(String.valueOf(rowOnPage));

            }
        }

    }

    public void setSlider(JSlider slider) {
        this.slider = slider;
    }

    public void setSliderMark(JLabel sliderMark) {
        this.sliderMark = sliderMark;
    }

    public void setRowOnPage(int rowOnPage) {
        this.rowOnPage = rowOnPage;
    }
}


