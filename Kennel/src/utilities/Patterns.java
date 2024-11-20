package utilities;

import java.util.regex.Pattern;

public class Patterns {

    public static final Pattern PATTERN_NOM = Pattern.compile("\\b([A-Z][A-Za" +
            "-z]{1,})\\b");
    public static final Pattern PATTERN_ESPECE = Pattern.compile("\\b([a-z][A" +
            "-Za-z]{2,})\\b");
    public static final Pattern PATTERN_DATE_NAISSANCE = Pattern.compile("\\b(0[1-9]|[12][0-9]|3[0-1])\\/(0[1-9]|1[0-2])\\/((19|2[0-9])[0-9]{2})\\b");
}
