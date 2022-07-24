import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (null == text || text.isEmpty()) {
            return 0;
        }

        String[] tokens = text.split(",|:");

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }

        return sum(tokens);
    }

    private static int sum(String[] tokens) {
        return StringNumber.of(tokens)
                .sum();
    }
}
