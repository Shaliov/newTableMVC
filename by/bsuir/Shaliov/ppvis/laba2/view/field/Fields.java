package by.bsuir.Shaliov.ppvis.laba2.view.field;

import by.bsuir.Shaliov.ppvis.laba2.enumeration.NameOfAcademicDegree;
import by.bsuir.Shaliov.ppvis.laba2.enumeration.NameOfAcademicTitle;
import by.bsuir.Shaliov.ppvis.laba2.enumeration.NameOfDepartment;
import by.bsuir.Shaliov.ppvis.laba2.enumeration.NameOfFaculty;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Andrey on 5/31/2016.
 */
public class Fields {

    private JTextField name;
    private JTextField secondaryName;
    private JTextField middleName;
    private JComboBox departmentName;
    private JComboBox faculty;
    private JComboBox academicTitle;
    private JComboBox academicDegree;
    private NameOfDepartment nameOfDepartment;
    private NameOfFaculty nameOfFaculty;
    private NameOfAcademicTitle nameOfAcademicTitle;
    private NameOfAcademicDegree nameOfAcademicDegree;

    public Fields() {

    }

    public void fio(Box boxPanel) {
        Box nameBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("имя преподавателя:");
        nameLabel.setPreferredSize(new Dimension(130, nameLabel.getHeight()));
        name = new JTextField(20);

        nameBox.add(nameLabel);
        nameBox.add(Box.createHorizontalStrut(6));
        nameBox.add(name);
        boxPanel.add(nameBox);
        boxPanel.add(Box.createVerticalStrut(12));

        Box secondaryBox = Box.createHorizontalBox();
        JLabel secondaryLabel = new JLabel("фамилия преподавателя:");
        secondaryLabel.setPreferredSize(new Dimension(130, secondaryLabel.getHeight()));
        secondaryName = new JTextField(20);

        secondaryBox.add(secondaryLabel);
        secondaryBox.add(Box.createHorizontalStrut(6));
        secondaryBox.add(secondaryName);
        boxPanel.add(secondaryBox);
        boxPanel.add(Box.createVerticalStrut(12));

        Box middleNameBox = Box.createHorizontalBox();
        JLabel middleNameLabel = new JLabel("отчество преподавателя:");
        middleNameLabel.setPreferredSize(new Dimension(130, middleNameLabel.getHeight()));
        middleName = new JTextField(20);

        middleNameBox.add(middleNameLabel);
        middleNameBox.add(Box.createHorizontalStrut(6));
        middleNameBox.add(middleName);
        boxPanel.add(middleNameBox);
        boxPanel.add(Box.createVerticalStrut(12));


    }
    public void departmentName(Box boxPanel){
        Box departmentNameBox = Box.createHorizontalBox();
        JLabel departmentNameLabel = new JLabel("Название кафедры:");
        departmentNameLabel.setPreferredSize(new Dimension(130, departmentNameLabel.getHeight()));
        departmentName = new JComboBox(nameOfDepartment.values());

        departmentNameBox.add(departmentNameLabel);
        departmentNameBox.add(Box.createHorizontalStrut(6));
        departmentNameBox.add(departmentName);
        boxPanel.add(departmentNameBox);
        boxPanel.add(Box.createVerticalStrut(12));
    }
    public void faculty(Box boxPanel) {
        Box facultyBox = Box.createHorizontalBox();
        JLabel facultyLabel = new JLabel("Факультет:");
        facultyLabel.setPreferredSize(new Dimension(130, facultyLabel.getHeight()));
        faculty = new JComboBox(nameOfFaculty.values());

        facultyBox.add(facultyLabel);
        facultyBox.add(Box.createHorizontalStrut(6));
        facultyBox.add(faculty);
        boxPanel.add(facultyBox);
        boxPanel.add(Box.createVerticalStrut(12));
    }
    public void academicTitle(Box boxPanel) {
        Box academicTitleBox = Box.createHorizontalBox();
        JLabel academicTitleLabel = new JLabel("ученое звание:");
        academicTitleLabel.setPreferredSize(new Dimension(130, academicTitleLabel.getHeight()));
        academicTitle = new JComboBox(nameOfAcademicTitle.values());

        academicTitleBox.add(academicTitleLabel);
        academicTitleBox.add(Box.createHorizontalStrut(6));
        academicTitleBox.add(academicTitle);
        boxPanel.add(academicTitleBox);
        boxPanel.add(Box.createVerticalStrut(12));}
    public void academicDegree(Box boxPanel) {
        Box academicDegreeBox = Box.createHorizontalBox();
        JLabel academicDegreeLabel = new JLabel("ученая степень:");
        academicDegreeLabel.setPreferredSize(new Dimension(130, academicDegreeLabel.getHeight()));
        academicDegree = new JComboBox(nameOfAcademicDegree.values());

        academicDegreeBox.add(academicDegreeLabel);
        academicDegreeBox.add(Box.createHorizontalStrut(6));
        academicDegreeBox.add(academicDegree);
        boxPanel.add(academicDegreeBox);
        boxPanel.add(Box.createVerticalStrut(12));
    }




    public JTextField getName() {
        return name;
    }

    public JTextField getSecondaryName() {
        return secondaryName;
    }

    public JTextField getMiddleName() {
        return middleName;
    }

    public JComboBox getDepartmentName() {
        return departmentName;
    }

    public JComboBox getFaculty() {
        return faculty;
    }

    public JComboBox getAcademicTitle() {
        return academicTitle;
    }

    public JComboBox getAcademicDegree() {
        return academicDegree;
    }

    public NameOfDepartment getNameOfDepartment() {
        return nameOfDepartment;
    }

    public NameOfFaculty getNameOfFaculty() {
        return nameOfFaculty;
    }

    public NameOfAcademicTitle getNameOfAcademicTitle() {
        return nameOfAcademicTitle;
    }

    public NameOfAcademicDegree getNameOfAcademicDegree() {
        return nameOfAcademicDegree;
    }

}
