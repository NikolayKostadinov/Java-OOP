package models.appenders;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Layout;

public class ConsoleAppender extends BaseAppender {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    protected void append(String text) {
        System.out.println(text);
    }
}
