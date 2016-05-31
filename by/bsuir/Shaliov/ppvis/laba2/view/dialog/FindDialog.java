package by.bsuir.Shaliov.ppvis.laba2.view.dialog;

import by.bsuir.Shaliov.ppvis.laba2.view.field.Fields;
import by.bsuir.Shaliov.ppvis.laba2.view.panel.TableComponent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrey on 5/31/2016.
 */
public class FindDialog extends JFrame {
    private TableComponent tableComponent;

    public FindDialog() {
        setName("Введите данные преподавателя");
        Box boxPanel = Box.createVerticalBox();
        Fields fields = new Fields();

        fields.fio(boxPanel);
        fields.departmentName(boxPanel);
        fields.faculty(boxPanel);
        fields.academicTitle(boxPanel);
        fields.academicDegree(boxPanel);


        tableComponent = new TableComponent();
        add(tableComponent.getScrollPane());

        JToolBar fieldBar = new JToolBar();
        fieldBar.setOrientation(SwingConstants.VERTICAL);
        boxPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
        add(boxPanel, "West");

        JToolBar findBar = new JToolBar();
        findBar.setOrientation(SwingConstants.HORIZONTAL);
        add(findBar, "South");
        findButtons(findBar);


        setSize(900, 320);
        setUndecorated(true);
        setVisible(true);
    }

    private void findButtons(JToolBar secondBar) {
        AbstractAction findFioDepartmentName = new AbstractAction("ФИО + кафедра") {
            public void actionPerformed(ActionEvent event) {

            }
        };
        secondBar.add(findFioDepartmentName);
        secondBar.addSeparator();
        AbstractAction findAcademicTitleDepartmentName = new AbstractAction("кафедра + учёное звание") {
            public void actionPerformed(ActionEvent event) {

            }
        };
        secondBar.add(findAcademicTitleDepartmentName);
        secondBar.addSeparator();
        AbstractAction findFacultyDepartmentName = new AbstractAction("факультет + кафедра") {
            public void actionPerformed(ActionEvent event) {

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
        secondBar.addSeparator(new Dimension(300, secondBar.getHeight()));
        secondBar.add(cancelButton);
    }
}
