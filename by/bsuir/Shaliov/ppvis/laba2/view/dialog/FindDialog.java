package by.bsuir.Shaliov.ppvis.laba2.view.dialog;

import by.bsuir.Shaliov.ppvis.laba2.controller.TableController;
import by.bsuir.Shaliov.ppvis.laba2.enumeration.AcademicTitles;
import by.bsuir.Shaliov.ppvis.laba2.enumeration.Departments;
import by.bsuir.Shaliov.ppvis.laba2.enumeration.Facultyes;
import by.bsuir.Shaliov.ppvis.laba2.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba2.storage.DBStorage;
import by.bsuir.Shaliov.ppvis.laba2.view.bar.SecondBar;
import by.bsuir.Shaliov.ppvis.laba2.view.field.Fields;
import by.bsuir.Shaliov.ppvis.laba2.view.panel.TableComponent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by Andrey on 5/31/2016.
 */
public class FindDialog extends JFrame {
    private TableComponent tableComponent;
    private List<Teacher> teachers;
    private Fields fields;
    private DBStorage dbStorage = DBStorage.getInstance();
    private TableController tableController = TableController.getInstance();
    private SecondBar secondBar;
    

    public FindDialog() {
        setName("Введите данные преподавателя");
        Box boxPanel = Box.createVerticalBox();
        fields = new Fields();

        fields.fio(boxPanel);
        fields.departmentName(boxPanel);
        fields.faculty(boxPanel);
        fields.academicTitle(boxPanel);
        fields.academicDegree(boxPanel);


        teachers = new ArrayList<>();
        tableComponent = new TableComponent(teachers);
        add(tableComponent.getScrollPane());

        JToolBar fieldBar = new JToolBar();
        fieldBar.setOrientation(SwingConstants.VERTICAL);
        boxPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
        add(boxPanel, "West");

        JToolBar findBar = new JToolBar();
        findBar.setOrientation(SwingConstants.VERTICAL);
        add(findBar, "East");
        findButtons(findBar);

        SecondBar secondBar = new SecondBar();
        add(secondBar, "South");


        setSize(900, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void findButtons(JToolBar secondBar) {
        AbstractAction findFioDepartmentName = new AbstractAction("ФИО + кафедра") {
            public void actionPerformed(ActionEvent e) {
                teachers.clear();
                String fio = fields.getName().getText() + " " + fields.getSecondaryName().getText() + " " + fields.getMiddleName().getText();
                for(Teacher teacher : dbStorage.getTeacherList() ){
                    if (teacher.getFio().equals(fio)
                            && teacher.getDepartmentName() == Departments.valueOf(fields.getDepartmentName().getSelectedItem().toString()).getName()) {
                        teachers.add(teacher);
                    }
                }
                tableController.refresh();
                repaint();

            }
        };
        secondBar.add(findFioDepartmentName);
        secondBar.addSeparator();
        AbstractAction findAcademicTitleDepartmentName = new AbstractAction("кафедра + учёное звание") {
            public void actionPerformed(ActionEvent event) {
                teachers.clear();
                for(Teacher teacher : dbStorage.getTeacherList() ) {
                    if (teacher.getDepartmentName() == Departments.valueOf(fields.getDepartmentName().getSelectedItem().toString()).getName()
                            && teacher.getAcademicTitle() == AcademicTitles.valueOf(fields.getAcademicTitle().getSelectedItem().toString())) {
                        teachers.add(teacher);
                    }
                }
                tableController.refresh();
                repaint();

            }
        };
        secondBar.add(findAcademicTitleDepartmentName);
        secondBar.addSeparator();
        AbstractAction findFacultyDepartmentName = new AbstractAction("факультет + кафедра") {
            public void actionPerformed(ActionEvent event) {
                teachers.clear();
                for(Teacher teacher : dbStorage.getTeacherList() ){
                    if (teacher.getFaculty() == Facultyes.valueOf(fields.getFaculty().getSelectedItem().toString()).getName()
                            && teacher.getDepartmentName() == Departments.valueOf(fields.getDepartmentName().getSelectedItem().toString()).getName()) {
                        teachers.add(teacher);
                    }
                }
                tableController.refresh();
                repaint();

            }
        };
        secondBar.add(findFacultyDepartmentName);
        JButton cancelButton = new JButton("Закрыть");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        secondBar.addSeparator(new Dimension(5, 100));
        secondBar.add(cancelButton);
    }

}
