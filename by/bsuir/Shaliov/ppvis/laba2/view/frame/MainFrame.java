package by.bsuir.Shaliov.ppvis.laba2.view.frame;

import by.bsuir.Shaliov.ppvis.laba2.view.bar.*;
import by.bsuir.Shaliov.ppvis.laba2.view.panel.TableComponent;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Andrey on 5/30/2016.
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setTitle("Table");
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);

        by.bsuir.Shaliov.ppvis.laba2.view.bar.MenuBar menuBar = new by.bsuir.Shaliov.ppvis.laba2.view.bar.MenuBar();
        add(menuBar, "North" );

        MainBar mainBar = new MainBar();
        mainBar.setOrientation(SwingConstants.VERTICAL);
        add(mainBar, "West");

        SecondBar secondBar = new SecondBar();
        add(secondBar, "South");

        TableComponent tableComponent = new TableComponent();
        add(tableComponent.getScrollPane());

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}