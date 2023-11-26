package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;

/**
 * JUnit 5 cho phép chúng ta tạo các test case tạo thời điểm runtime bằng cách định nghĩa chúng bên trong method được bao bởi @TestFactory.
 * @TestFactory method phải trả về các kiểu dữ liệu dạng danh sách như Stream, Collection, Iterable, etc.
 * Ngoài ra @TestFactory method không được là static method hoặc access private.
 */
public class FactoryTest {
    @TestFactory
    @DisplayName("Test Factory")
    public List<DynamicTest> testFactoryExample() {
        //2 Test case sau được khởi tạo tại thời điểm runtime (thời điểm hàm testFactoryExample chạy)
        return Arrays.asList(
                DynamicTest.dynamicTest("So sánh tổng", () -> Assertions.assertEquals(4, 2 * 2)),
                DynamicTest.dynamicTest("Kiểm tra biến boolean", () -> Assertions.assertTrue(true)));
    }
}
