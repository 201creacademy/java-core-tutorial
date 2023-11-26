package junit;


import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * Sử dụng @SelectClasses để chạy tất cả các test class được liệt kê
 */
@RunWith(JUnitPlatform.class)
@SelectClasses({AssertionsTest.class, AssumptionsTest.class, ExceptionTest.class})
public class SelectClassesTest {
    //Chạy test cases trong các class "AssertionsTest", "AssumptionsTest", "ExceptionTest"
}
