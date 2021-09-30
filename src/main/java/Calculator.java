

import java.util.function.*;

public class Calculator {

    static Supplier instance;

    public Calculator() {

    }

    public static Supplier getInstance() {

        return instance;
    }

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    //необходимо реализовать проверку или будет исключение ArithmeticException
    BinaryOperator<Integer> devide = (x, y) -> {
        if (y!=0) {
            return x/y;
        } else {
            throw new  ArithmeticException("деление на ноль");
        }
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;

}


