import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void add_null_또는_빈문자() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void add_숫자하나() throws Exception {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void add_쉼표구분자() throws Exception {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void add_custom_구분자() throws Exception {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void add_negative() throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=1", "1,2=3", "1,2:3=6"}, delimiter = '=')
    public void add_숫자하나_또는_구분자(String actual, int expected) {
        assertThat(StringCalculator.splitAndSum(actual)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,-2,3", "1,2,-3"})
    public void 음수_위치_여러개(String text) throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }
}
