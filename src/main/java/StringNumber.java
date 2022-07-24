import java.util.Arrays;

public class StringNumber {
    private static String[] tokens;

    public StringNumber(String[] tokens) {
        validateTokens(tokens);
        this.tokens = tokens;
    }

    public static StringNumber of(String[] tokens) {
        return new StringNumber(tokens);
    }

    private void validateTokens(String[] tokens) {
        for(String token : tokens) {
            this.isCorrectNumber(token);
        }
    }

    private void isCorrectNumber(String token) {
        int number = Integer.parseInt(token);

        if (number < 0) {
            throw new RuntimeException();
        }
    }

    static int sum() {
        int sum = Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
        return sum;
    }
}
