package by.bsuir.Shaliov.ppvis.laba2.XML;

import by.bsuir.Shaliov.ppvis.laba2.model.TableModel;
import by.bsuir.Shaliov.ppvis.laba2.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba2.storage.DBStorage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Created by Andrey on 5/25/2016.
 */
public class WriteXML extends AbstractAction {
    private TableModel model = TableModel.getInstance();
    private JFileChooser fileChooser;
    private File file;

    public WriteXML() {
    }

    public void actionPerformed(ActionEvent e) {
        try {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = f.newDocumentBuilder();
            fileChooser = new JFileChooser();
            FileXML filter = new FileXML();
            fileChooser.setAcceptAllFileFilterUsed(true);
            fileChooser.addChoosableFileFilter(filter);
            int result1 = fileChooser.showSaveDialog(null);
            if (result1 == JFileChooser.APPROVE_OPTION) {
                String fileName = fileChooser.getSelectedFile().getAbsolutePath();
                if (fileChooser.getFileFilter() == filter) {
                    file = new File(fileName + ".xml");
                } else {
                    file = new File(fileName);
                }
                if (!file.exists()) {
                    file.createNewFile();
                }

                Document doc = builder.newDocument();
                Element tableEl = doc.createElement("teachers");
                doc.appendChild(tableEl);

                for (Teacher teachers : DBStorage.getInstance().getTeacherList()) {
                    Element teacher = doc.createElement("teacher");
                    tableEl.appendChild(teacher);

                    Element name = doc.createElement("name");
                    name.appendChild(doc.createTextNode(teachers.getName()));
                    teacher.appendChild(name);

                    Element subName = doc.createElement("secondaryName");
                    subName.appendChild(doc.createTextNode(teachers.getSecondaryName()));
                    teacher.appendChild(subName);

                    Element middleName = doc.createElement("middleName");
                    middleName.appendChild(doc.createTextNode(teachers.getMiddleName()));
                    teacher.appendChild(middleName);

                    Element departmentName = doc.createElement("departmentName");
                    departmentName.appendChild(doc.createTextNode(teachers.getDepartmentName().toString()));
                    teacher.appendChild(departmentName);

                    Element faculty = doc.createElement("faculty");
                    faculty.appendChild(doc.createTextNode(teachers.getFaculty().toString()));
                    teacher.appendChild(faculty);

                    Element academicTitle = doc.createElement("academicTitle");
                    academicTitle.appendChild(doc.createTextNode(teachers.getAcademicTitle().toString()));
                    teacher.appendChild(academicTitle);

                    Element academicDegree = doc.createElement("academicDegree");
                    academicDegree.appendChild(doc.createTextNode(teachers.getAcademicDegree().toString()));
                    teacher.appendChild(academicDegree);
                }

                TransformerFactory tFactory = TransformerFactory
                        .newInstance();
                Transformer transformer = tFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(file);
                transformer.transform(source, result);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}

