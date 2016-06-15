package by.bsuir.Shaliov.ppvis.laba2.XML;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Andrey on 5/25/2016.
 */
public class FileXml extends FileFilter {
    private String ext = ".xml";

    public boolean accept(File file) {
        if (file.isDirectory()) return true;
        return (file.getName().endsWith(ext));
    }

    public String getDescription() {
        return "*"+ext;
    }
}
