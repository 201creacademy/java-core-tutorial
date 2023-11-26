package junit;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * Sử dụng @SelectPackages để chạy tất cả các test class bên trong package được chỉ định.
 */
@RunWith(JUnitPlatform.class)
@SelectPackages("junit")
public class SelectPackagesTest {
    //Chạy test cases trong các class nằm trong package "junit"
}
