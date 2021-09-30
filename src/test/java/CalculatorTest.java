import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
        System.out.println("Test started");

    }

    @AfterEach
    void tearDown() {
        System.out.println("Test finished");

    }

    @Test
    @DisplayName("Проверяем сложение")
    void plus (){

        int a = 10;
        int b = 5;
        int expected = 15;

        final int result = calc.plus.apply(a,b);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверяем деление")
    void devide (){

        int a = 30;
        int b = 5;
        final int expected = 6;

        final int result = calc.devide.apply(a,b);

        Assertions.assertEquals(expected,result);

    }

    @Test
    @DisplayName("Проверка деления на 0")
    void devideByZero (){

        int a = 30;
        int b = 0;

       Assertions.assertThrows(ArithmeticException.class,
                ()-> calc.devide.apply(a,b));

    }

    @Test
    @DisplayName("Проверяем логическое выражение")
    void isPositive (){

        int a = 10;

        final boolean expected = true;

        boolean result = calc.isPositive.test(a);
        Assertions.assertEquals(expected, result);
    }
}