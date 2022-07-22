import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String text) {
        if (null == text || text.isEmpty()) {
            return 0;
        }

        String[] tokens = text.split(",|:");

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }

        return addSplit(tokens);
    }

    private static int addSplit(String[] tokens) {
        checkNumber(tokens);
        int sum = 0;

        for (String number : tokens) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static void checkNumber(String[] tokens) {
        Arrays.stream(tokens).forEach(number -> {
          if(Integer.parseInt(number) < 0) {
              throw new RuntimeException();
          }
        });
    }
}
