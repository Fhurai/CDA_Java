package utilities;

import java.util.regex.Pattern;

public class Patterns {

    public static final Pattern PATTERN_NOM = Pattern.compile("\\b([A-Z][A-Za" +
            "-z]{1,})\\b");
    public static final Pattern PATTERN_ESPECE = Pattern.compile("\\b([a-z][A" +
            "-Za-z]{2,})\\b");
}
