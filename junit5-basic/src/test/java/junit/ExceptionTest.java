package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Đôi lúc chúng ta mong đợi kết quả trả về là một exception vì dữ liệu của chúng ta không đúng hoặc dữ liệu xung đột etc.
 * Sử dụng assertThrows() để mong đợi kết quả trả về là một exception.
 */
@DisplayName("Exception Test")
public class ExceptionTest {
    /**
     * Test thông tin chi tiết Exception
     */
    @Test
    @DisplayName("Test thông tin chi tiết Exception")
    void shouldThrowException() {
        //throw ra UnsupportedOperationException và kiểm tra xem message của Exception có đúng hay không
        Throwable exception = Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Không hỗ trợ");
        });
        Assertions.assertEquals("Không hỗ trợ", exception.getMessage());
    }

    /**
     * Test loại Exception
     */
    @Test
    @DisplayName("Test loại Exception")
    void assertThrowsException() {
        String str = null;
        //Kiểm tra xem convert từ null string sang Integer có throw ra IllegalArgumentException hay không
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(str);
        });
    }
}
