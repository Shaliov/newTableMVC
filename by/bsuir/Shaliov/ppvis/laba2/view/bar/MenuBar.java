package by.bsuir.Shaliov.ppvis.laba2.view.bar;

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
//
            }
        });
        fileMenu.add(saveFile);
        JMenuItem openFile = new JMenuItem("Open file");
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        fileMenu.add(openFile);
        JMenuItem closeFile = new JMenuItem("Close file");
        closeFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        fileMenu.add(closeFile);
    }

}
