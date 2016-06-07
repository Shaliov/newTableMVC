package by.bsuir.Shaliov.ppvis.laba2.view.dialog;

import by.bsuir.Shaliov.ppvis.laba2.controller.AddDialogController;
import by.bsuir.Shaliov.ppvis.laba2.controller.SecondBarController;
import by.bsuir.Shaliov.ppvis.laba2.enumeration.AcademicDegrees;
import by.bsuir.Shaliov.ppvis.laba2.enumeration.AcademicTitles;
import by.bsuir.Shaliov.ppvis.laba2.enumeration.Departments;
import by.bsuir.Shaliov.ppvis.laba2.enumeration.Facultyes;
import by.bsuir.Shaliov.ppvis.laba2.view.field.Fields;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrey on 5/31/2016.
 */
public class AddDialog extends JFrame {

    private Fields fields;
    private AddDialogController addDialogController = AddDialogController.getInstance();

    public AddDialog() {
        setName("Введите данные преподавателя");

        Box boxPanel = Box.createVerticalBox();
        fields = new Fields();

        fields.fio(boxPanel);
        fields.departmentName(boxPanel);
        fields.faculty(boxPanel);
        fields.academicTitle(boxPanel);
        fields.academicDegree(boxPanel);
        okCancle(boxPanel);

        boxPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
        setContentPane(boxPanel);
        pack();
        setResizable(false);
        setPreferredSize(new Dimension(600, boxPanel.getHeight()));
        setSize(new Dimension(400, boxPanel.getHeight() + 20));

    }

    private void okCancle(Box boxPanel) {
        Box okBox = Box.createHorizontalBox();
        JButton okButton = new JButton("Ok");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(fields.getName().getText() + fields.getSecondaryName().getText() +
                        fields.getMiddleName().getText()).equals("")) {
                    addDialogController.addTeacherToDB(
                            Facultyes.valueOf(fields.getFaculty().getSelectedItem().toString()).getName(),
                            Departments.valueOf(fields.getDepartmentComboBox().getSelectedItem().toString()).getName(),
                            fields.getName().getText(),
                            fields.getSecondaryName().getText(),
                            fields.getMiddleName().getText(),
                            AcademicTitles.valueOf(fields.getAcademicTitle().getSelectedItem().toString()).getName(),
                            AcademicDegrees.valueOf(fields.getAcademicDegree().getSelectedItem().toString()).getName());

                }
                fields.getName().setText("");
                fields.getSecondaryName().setText("");
                fields.getMiddleName().setText("");
                SecondBarController.getInstance().changeNumberOfPage();
            }
        });
        JButton cancelButton = new JButton("Закрыть");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fields.getName().setText("");
                fields.getSecondaryName().setText("");
                fields.getMiddleName().setText("");
                SecondBarController.getInstance().changeNumberOfPage();
                dispose();
            }
        });

        okBox.add(Box.createHorizontalGlue());
        okBox.add(okButton);
        okBox.add(Box.createHorizontalStrut(12));
        okBox.add(cancelButton);
        boxPanel.add(okBox);
        boxPanel.add(Box.createVerticalStrut(12));
    }

    public Fields getFields() {
        return fields;
    }
}
