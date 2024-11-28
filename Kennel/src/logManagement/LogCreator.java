package logManagement;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogCreator {

    public static final Logger publisher =
            Logger.getLogger(LogCreator.class.getName());

    public static void init() throws IOException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        FileHandler fh = new FileHandler("logs/log" + date.format(df) + ".log", true);
        publisher.setUseParentHandlers(false);
        publisher.addHandler(fh);
        fh.setFormatter(new LogFormatter());
    }

    public static void run(){
        LogCreator.publisher.log(Level.INFO, "Software running");
    }

    public static void info(String msg){
        publisher.log(Level.INFO, msg);
    }

    public static void stop(){
        LogCreator.publisher.log(Level.INFO, "Software stopped");
    }
}
