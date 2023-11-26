package junit;

import org.junit.jupiter.api.*;

@DisplayName("Basic Annotation Test")
public class BasicAnnotationTest {
    /**
     * @BeforeAll được dùng để chỉ định một test method chạy đầu tiên trong một test class.
     * Lưu ý @BeforeAll phải được đặt trên static method, nếu không chương trình sẽ không biên dịch được.
     * @BeforeAll thường được dùng để chuẩn bị các data dùng chung cho các test method khác.
     */
    @BeforeAll
    static void setup() {
        System.out.println("Before all");
    }

    /**
     * @BeforeEach chỉ định 1 method sẽ luôn được thực thi trước mỗi test method thực thi.
     */
    @BeforeEach
    public void beforeEach() {
        System.out.println("BeforeEach");
    }

    /**
     * @AfterEach Chỉ định 1 method luôn thực thi sau khi 1 test method thực thi xong
     */
    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    /**
     * @AfterAll Chỉ định method sẽ được thực thi khi tất cả các test method trong class thực thi xong. @AfterAll phải được đặt trên static method.
     */
    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }

    /**
     * Test Method
     */
    @Test
    @DisplayName("My test method")
    public void test() {
        System.out.println("Test");
    }

    /**
     * @Disabled ngăn chặn disable() method không được thực thi
     */
    @Test
    @Disabled
    public void disable() {
        System.out.println("disable");
    }


}
