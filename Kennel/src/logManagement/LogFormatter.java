package logManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb = new StringBuilder();

        sb.append(format.format(new Date()));
        sb.append(" | Level: ").append(record.getLevel());
        sb.append(" | Class :").append(record.getSourceClassName());
        sb.append(" | Method : ").append(record.getSourceMethodName());
        sb.append(" | Message : ").append(record.getMessage());
        sb.append("\n");

        return sb.toString();
    }
}
