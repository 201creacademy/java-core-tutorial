package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Assumption được sử dụng để đảm bảo rằng các dữ liệu được chuẩn bị cho test method phải đúng trước khi chúng thực thi.
 * Nếu các điều kiện bên trong Assumption false, test method sẽ bị ignore.
 */
@DisplayName("Assumptions Test")
public class AssumptionsTest {
    /**
     * assumeTrue Đảm bảo điều kiện phải đúng trước khi thực thi test method.
     */
    @Test
    @DisplayName("assumeTrue example")
    public void trueAssumption() {
        Integer sum = 24;
        Integer a = 10;
        Integer b = 14;
        //Nếu a < b là đúng, thực hiện assertEquals
        Assumptions.assumeTrue(a < b);

        Assertions.assertEquals(sum, a + b);
    }

    /**
     * assumeFalse Đảm bảo điều kiện phải sai trước khi thực thi test method.
     */
    @Test
    @DisplayName("assumeFalse example")
    public void falseAssumption() {
        Integer sum = 24;
        Integer a = 10;
        Integer b = 14;
        //Nếu a > b là sai, thực hiện assertEquals
        Assumptions.assumeFalse(a > b);

        Assertions.assertEquals(sum, a + b);
    }

    /**
     * assumeThat được sử dụng để kết hợp assume và assert 1 cách nhanh chóng.
     */
    @Test
    @DisplayName("assumingThat example")
    public void thatAssumption() {
        Integer sum = 24;
        Integer a = 10;
        Integer b = 14;
        // Nếu a > b thì sẽ thực hiện assertEquals, nếu không sẽ không thực hiện gì
        Assumptions.assumingThat(a > b,
                () -> Assertions.assertEquals(sum, a + b));
    }
}
