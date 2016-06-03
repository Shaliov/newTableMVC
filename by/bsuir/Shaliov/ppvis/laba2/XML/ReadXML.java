package by.bsuir.Shaliov.ppvis.laba2.XML;

import by.bsuir.Shaliov.ppvis.laba2.controller.TableController;
import by.bsuir.Shaliov.ppvis.laba2.controller.XMLRead;
import by.bsuir.Shaliov.ppvis.laba2.model.TableModel;
import by.bsuir.Shaliov.ppvis.laba2.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba2.storage.DBStorage;
import by.bsuir.Shaliov.ppvis.laba2.view.panel.TableComponent;
import com.sun.javafx.scene.control.behavior.TableViewBehavior;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * Created by Andrey on 5/26/2016.
 */
public class ReadXML {
    private JFileChooser fileChooser;
    private File file;

    public ReadXML() {
    }

    public void actionPerformed(ActionEvent e) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        try {
            parser = factory.newSAXParser();
            XMLRead saxp = new XMLRead();
            fileChooser = new JFileChooser();
            FileXML filter = new FileXML();
            fileChooser.setAcceptAllFileFilterUsed(true);
            fileChooser.addChoosableFileFilter(filter);
            int result1 = fileChooser.showOpenDialog(null);
            if (result1 == JFileChooser.APPROVE_OPTION){
                String fileName = fileChooser.getSelectedFile().getAbsolutePath();
                file = new File(fileName);

                parser.parse(file, saxp);
                List<Teacher> result = saxp.getTeachers();
                TableController.getInstance().clear();
                for(Teacher teacher:result){
                    DBStorage.getInstance().add(teacher);
                    TableController.getInstance().refresh();
                }
                TableModel.getInstance().setTempList(DBStorage.getInstance().getTeacherList());
            }
        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
        } catch (SAXException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

    }
}
