# 201CreAcademy - JUnit 5 Basic
JUnit là một java testing framework được sử dụng rộng rãi trong các dự án java. JUnit 5 là phiên bản mới của JUnit với mục đích hỗ trợ các tính năng mới ra mắt từ Java 8 trở về sau.

Bài viết này sẽ hướng dẫn các bạn sử dụng JUnit 5 để thực hiện các test case cơ bản.
### Nội dung bài viết bao gồm các phần:
1. Giới thiệu JUnit 5
2. Cài đặt JUnit 5
3. Thực nghiệm với các annotation cơ bản

## 1. Giới thiệu JUnit 5
### JUnit 5 gồm có 3 module khác nhau từ 3 sub-project khác nhau:

- JUnit platform
- JUnit Jupiter
- JUnit Vintage

Chúng ta sẽ cùng tìm hiểu qua 3 sub-project ở bên dưới.

#### 1.1. JUnit Platform
JUnit platform chịu trách nhiệm khởi chạy JUnit framework trên JVM. Nó định nghĩa các interface mạnh mẽ và ổn định để tương thích tốt với các môi trường khác nhau như chạy trên các IDE khác nhau (Intellij, Eclipse, NetBean etc).

Ngoài ra, JUnit Platform cũng định nghĩa TestEngine API để phát triển các testing framework chạy nên JUnit platform. Chúng ta có thể sử dụng các thư viện tesing thứ 3 trực tiếp trên JUnit bằng cách implement TestEngine.

#### 1.2. JUnit Jupiter
JUnit Jupiter bao gồm các mô hình lập trình và mở rộng mới phục vụ để viết unit test trong JUnit 5. Nó bao gồm các annotation từ JUnit 4 và các annotation mới được thêm trong JUnit 5:

- **@Test** – Đặt ở đầu method để thông báo rằng method được dùng để kiểm thử(test method).
- **@ParameterizedTest** – Test method chạy nhiều lần với các tham số khác nhau.
- **@RepeatedTest**  -Test method chạy kiểm thử lặp lại n lần.
- **@TestFactory** – Chỉ định method là một test factory cho các dynamic test.
- **@TestTemplate** – Chỉ định method là một mẫu cho các test case.
- **@TestMethodOrder** – Cấu hình thứ tự thực thi cho các @Test.
- **@TestInstance** – Quy định vòng đời của cho các annotation test class (@Nested, biến static etc)
- **@DisplayName** – Đặt tên cho test class hoặc test method.
- **@DisplayNameGeneration** – Đặt tên cho các test class được generate.
- **@BeforeEach** – chỉ định 1 method luôn được thực thi trước mỗi test method thực thi.
- **@AfterEach** – chỉ định 1 method luôn thực thi sau khi 1 test method thực thi xong.
- **@BeforeAll** – Chỉ định method sẽ được thực thi đầu tiên trong test class.
- **@AfterAll** – Chỉ định method sẽ được thực thi khi tất cả các test method trong class thực thi xong.
- **@Disable** – Vô hiệu hoá một test method hay một test class thực thi (Tương ứng với @Ignore ở version cũ).

#### 1.3. JUnit Vintage
Hỗ trợ chạy các verrsion cũ của JUnit(3, 4) được viết trước đó khi hệ thống cập nhật lên JUnit 5.

## 2. Cài đặt JUnit 5
### 2.1. Điều kiện cài đặt
Trước khi import thư viện JUnit 5 cần cài đặt trước:
- Môi trường: 
  - Java version 8 trở lên
  - Maven
- Tool:
  - IDE: một trong những IDE: IntelliJ, Eclipse, Spring Tool Suite,...

### 2.2. JUnit Maven dependency
#### B1: Khởi tạo maven project
#### B2: Import thư viện JUnit 5 

Để cài đặt JUnit 5 trong dự án Maven, chúng ta chỉ cần thêm các dependency của JUnit vào file pom.xml. Mặc định thì các IDE như intellij, eclipse cũng đã hỗ trợ sẵn JUnit 5. Điều kiện tiên quyết, cài đặt maven thành công trên máy local.

```xml
<!-- Only needed to run tests in a version of IntelliJ IDEA that bundles older versions -->
<dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-launcher</artifactId>
    <version>1.6.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.6.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.vintage</groupId>
    <artifactId>junit-vintage-engine</artifactId>
    <version>5.6.0</version>
    <scope>test</scope>
</dependency>
```

## 3. Thực nghiệm với các annotation cơ bản
Chúng ta cùng điểm qua các annotation trong JUnit 5 và xem cách sử dụng cơ bản để hiểu thêm về cách hoạt động của JUnit.

### 3.1. @BeforeAll
@BeforeAll được dùng để chỉ định một test method chạy đầu tiên trong một test class. Lưu ý @BeforeAll phải được đặt trên static method, nếu không chương trình sẽ không biên dịch được. @BeforeAll thường được dùng để chuẩn bị các data dùng chung cho các test method khác.

```java
@BeforeAll
static void setup() {
  System.out.println("Before all");
}
```

### 3.2. @BeforeEach
@BeforeEach chỉ định 1 method sẽ luôn được thực thi trước mỗi test method thực thi.

```java
@BeforeEach
public void beforeEach() {
  System.out.println("BeforeEach");
}
```

### 3.3. @AfterAll
Chỉ định method sẽ được thực thi khi tất cả các test method trong class thực thi xong. @AfterAll phải được đặt trên static method.

```java
@AfterAll
public static void afterAll() {
  System.out.println("afterAll");
}
```

### 3.4. @AfterEach
Chỉ định 1 method luôn thực thi sau khi 1 test method thực thi xong

```java
@AfterEach
public void afterEach() {
  System.out.println("afterEach");
}
```

### 3.5. @DisplayName và Disable
@Disable được sử dụng để ngăn chặn một test method không được thực thi.

```java
package overview;
import org.junit.jupiter.api.*;

@DisplayName("JUnitExampleTest")
public class JUnitExampleTest {
  @BeforeAll
  static void setup() {
    System.out.println("Before all");
  }
  
  @BeforeEach
  public void beforeEach() {
    System.out.println("BeforeEach");
  }
  
  @Test
  @DisplayName("My test method")
  public void test() {
    System.out.println("Test");
  }
  
  @Test
  @Disabled
  public void disable() {
    System.out.println("disable");
  }
}
```

## 4. Assertion
Assertion dùng để kiểm tra kết quả của quá trình thực thi. Project phải luông cố gắng đạt đến trạng trái không có mệnh đề Assertion nào bị false vì bất cứ lý do gì.

Với JUnit 5 chúng ta có thể sử dụng lambda expression chung với assertion.

### 4.1. assertTrue
assertTrue sử dụng để kiểm tra xem kết quả có phải là true hay không?

```java
@Test
void assertTrueEx() {
  assertTrue(Stream.of(1, 2, 3)
  .mapToInt(i -> i)
  .sum() > 5, () -> "Sum should be greater than 5");
}
```

### 4.2. assertEquals
assertEquals(expected, actual) được sử dụng để kiểm tra kết quả tính toán có giống với kết quả mong đợi hay không?

```java
@Test
void assertEqualsEx() {
    assertEquals(7, 5 + 2);
}
```
### 4.3. assertAll
Ngoài ra, chúng ta còn có thể kết hợp nhiều assertion với nhau thông qua assertAll.

```java
@Test
void assertAllEx() {
  int[] numbers = {0, 1, 2, 3, 4};
  assertAll("numbers",
  () -> assertEquals(numbers[0], 1),
  () -> assertTrue(numbers[3] == 3, "should be 3"),
  () -> assertEquals(numbers[4], 1)
  );
}
```

## 5. Assumption
Assumption được sử dụng để đảm bảo rằng các dữ liệu được chuẩn bị cho test method phải đúng trước khi chúng thực thi. Nếu các điều kiện bên trong Assumption false, test method sẽ bị ignore.

### 5.1. assumeTrue
assumeTrue Đảm bảo điều kiện phải đúng trước khi thực thi test method.

```java
@Test
public void assumpTrue() {
  int x = 5, y = 4;
  assumeTrue(x < y);
  assertTrue(x - y < 0);
}

// Output
org.opentest4j.TestAbortedException: Assumption failed: assumption is not true
```

### 5.2. assumeFalse
assumeFalse Đảm bảo điều kiện phải trả về false trước khi thực thi test method.

```java
@Test
public void assumpFalse() {
  int x = 5, y = 4;
  assumeFalse(x < y);
  assertTrue(x - y < 0);
}
```
### 5.3. assumeThat
assumeThat để kết hợp assume và assert cách nhanh chóng.

```java
@Test
void assumptionThat() {
  String someString = "Just a string";
  assumingThat(
  someString.equals("Just a string"),
  () -> assertEquals(2 + 2, 4)
  );
}
```

## 6. Exception Testing
Đôi lúc chúng ta mong đợi kết quả trả về là một exception vì dữ liệu của chúng ta không đúng hoặc dữ liệu xung đột etc. Sử dụng assertThrows() để mong đợi kết quả trả về là một exception.

```java
@Test
void shouldThrowException() {
  Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
    throw new UnsupportedOperationException("Not supported");
  });
  assertEquals(exception.getMessage(), "Not supported");
}

@Test
void assertThrowsException() {
  String str = null;
  assertThrows(IllegalArgumentException.class, () -> {
    Integer.valueOf(str);
  })
}
```

## 7. Test Suite
JUnit Test suite cho phép chúng ta chạy một lúc nhiều test class, tính năng này sẽ rất hữu ích so với việc chúng ta phải chọn từng test class để chạy. Thực thi trong IntellIJ cũng cho phép chọn một package để chay tất cả các test class trong đó. Nếu các bạn dùng IDE khác thì có thể áp dụng nhé. JUnit cung cấp @SelectPackages and @SelectClasses để khởi tạo một test suite.

Lưu ý :Để tạo test suite chúng ta phải thêm junit-platform-runner dependency cho maven.

```xml
<dependency>
     <groupId>org.junit.platform</groupId>
     <artifactId>junit-platform-runner</artifactId>
     <version>1.6.0</version>
     <scope>test</scope>
</dependency>
```

### 7.1. @SelectPackages
Sử dụng @SelectPackages để chạy tất cả các test class bên trong package được chỉ định.

```java
package overview;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("overview")
public class TestAllSelectPackage {}
```

### 7.2. @SelectClasses
Sử dụng @SelectClasses để chạy tất cả các test class được liệt kê

```java
package overview;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({AssertTest.class, AssumpTest.class, ExceptionTest.class}) 
public class TestAllSelectClasses {}
 ```
## 8. Dynamic test
JUnit 5 cho phép chúng ta tạo các test case tạo thời điểm runtime bằng cách định nghĩa chúng bên trong method được bao bởi @TestFactory. @TestFactory method phải trả về các kiểu dữ liệu dạng danh sách như Stream, Collection, Iterable, etc. Ngoài ra @TestFactory method không được là static method hoặc access private.

```java
@TestFactory
public List<DynamicTest> exampleTestFactory() {
return Arrays.asList(
dynamicTest("Dynamic square " + 2, () -> assertEquals(4, 2 * 2)),//
dynamicTest("Dynamic true " + true, () -> assertTrue(true)));
}
```

Tóm lược
Như vậy JUnit đã cập nhật theo đời đại để nhanh chóng tương thích với các phiên bản Java mới. Giúp cho việc viết unit test trở nên đơn giản và tiện lợi hơn. Ngoài ra JUnit 5 còn triển khai một số tính năng mới bắt kịp xu hướng với cac công nghệ khác.

## Nguồn tham khảo

https://junit.org/junit5/docs/current/user-guide/#overview

https://www.baeldung.com/junit-5