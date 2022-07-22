import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void add_null_또는_빈문자() {
        int result = StringCalculator.add(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void add_숫자하나() throws Exception {
        int result = StringCalculator.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void add_쉼표구분자() throws Exception {
        int result = StringCalculator.add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringCalculator.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void add_custom_구분자() throws Exception {
        int result = StringCalculator.add("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void add_negative() throws Exception {
        assertThatThrownBy(() -> StringCalculator.add("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
