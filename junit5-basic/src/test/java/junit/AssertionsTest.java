package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * Assertion dùng để kiểm tra kết quả của quá trình thực thi.
 * Project phải luông cố gắng đạt đến trạng trái không có mệnh đề Assertion nào bị false vì bất cứ lý do gì.
 */
@DisplayName("Assertions Test")
public class AssertionsTest {
    /**
     * assertTrue sử dụng để kiểm tra xem kết quả có phải là true hay không?
     */
    @Test
    @DisplayName("assertTrue example")
    public void assertTrueExample() {
        Assertions.assertTrue(Stream.of(1, 2, 6)
                .mapToInt(i -> i)
                .sum() > 5, () -> "Tổng các số lớn hơn 5");
    }

    /**
     * assertEquals(expected, actual) được sử dụng để kiểm tra kết quả tính toán có giống với kết quả mong đợi hay không?
     */
    @Test
    @DisplayName("assertEquals example")
    public void assertEqualsExample() {
        Integer sum = 24;
        Integer a = 10;
        Integer b = 14;

        Assertions.assertEquals(sum, a + b);
    }

    /**
     * Ngoài ra, chúng ta còn có thể kết hợp nhiều assertion với nhau thông qua assertAll.
     */
    @Test
    @DisplayName("assertAll example")
    public void assertAllExample() {
        int[] numbers = {0, 1, 2, 3, 4};

        Assertions.assertAll("numbers",
                () -> Assertions.assertEquals(numbers[0], 0),
                () -> Assertions.assertTrue(numbers[3] == 3, "should be 3"),
                () -> Assertions.assertEquals(numbers[4], 4)
        );
    }
}
