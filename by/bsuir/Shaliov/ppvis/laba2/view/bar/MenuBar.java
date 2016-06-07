package by.bsuir.Shaliov.ppvis.laba2.view.bar;

import by.bsuir.Shaliov.ppvis.laba2.XML.ReadXML;
import by.bsuir.Shaliov.ppvis.laba2.XML.WriteXML;
import by.bsuir.Shaliov.ppvis.laba2.controller.MainFrameController;
import by.bsuir.Shaliov.ppvis.laba2.controller.SecondBarController;
import by.bsuir.Shaliov.ppvis.laba2.controller.TableController;
import by.bsuir.Shaliov.ppvis.laba2.storage.DBStorage;
import by.bsuir.Shaliov.ppvis.laba2.view.panel.TableComponent;
import com.sun.org.apache.xerces.internal.impl.dv.DVFactoryException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrey on 5/30/2016.
 */
public class MenuBar extends JMenuBar {

    public MenuBar() {
        JMenu fileMenu = new JMenu("File");
        addFileMenu(fileMenu);
        add(fileMenu);
    }
    private void addFileMenu(JMenu fileMenu) {

        fileMenu.setMnemonic('F');
        JMenuItem newFile = new JMenuItem("New file");
        newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        fileMenu.add(newFile);
        JMenuItem saveFile = new JMenuItem("Save");
        saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WriteXML writeXML = new WriteXML(SecondBarController.getInstance().getTableModel());
                writeXML.actionPerformed(e);

            }
        });
        fileMenu.add(saveFile);
        JMenuItem openFile = new JMenuItem("Open file");
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReadXML readXML = new ReadXML(SecondBarController.getInstance().getTableModel());
                readXML.actionPerformed(e);
                TableController.getInstance().firstPage();
            }
        });
        fileMenu.add(openFile);
        JMenuItem closeFile = new JMenuItem("Close file");
        closeFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBStorage.getInstance().getTeacherList().clear();
                TableController.getInstance().refresh();
                MainFrameController.getInstance().refresh();
            }
        });
        fileMenu.add(closeFile);
    }

}
