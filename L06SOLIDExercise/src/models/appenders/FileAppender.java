package models.appenders;

import interfaces.File;
import interfaces.Layout;
import models.files.LogFile;


public class FileAppender extends BaseAppender {
    private File file;
    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    @Override
    protected void append(String text) {
        this.file.write(text);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", File size: %d", this.file.getSize());
    }
}
