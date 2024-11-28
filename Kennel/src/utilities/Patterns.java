package utilities;

import java.util.regex.Pattern;

public class Patterns {

    public static final Pattern PATTERN_NOM = Pattern.compile("\\b([A-Z\\u0080-\\uFFFF][a-zA-Z\\u0080-\\uFFFF]{1,})\\b");
    public static final Pattern PATTERN_ESPECE = Pattern.compile("\\b([a-z][A-Za-z]{2,})\\b");
}
