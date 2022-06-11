package no.sikt.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionEvaluatorTest {

    @Test
    void shouldReturnValueWhenExpressionIsValid()  {
        var expected = 42;
        var expression = "6 5 2 + *";
        var actual = new ExpressionEvaluator(expression).getResult();
        assertEquals(expected, actual);
    }

    @Test
    void zeroDivisionCausedByExpression()  {
        var expression = "6 5 0 / *";
        ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
            new ExpressionEvaluator(expression).getResult();
        });
        Assertions.assertEquals("The operation value sequence lead to zero division", thrown.getMessage());
    }

    @Test
    void emptyExpression() {
        var expression = "";
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            new ExpressionEvaluator(expression).getResult();
        });
    }

    @Test
    void notEnoughNumbers()  {
        var expression = "2 3 + *";
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new ExpressionEvaluator(expression).getResult();
        });
        Assertions.assertEquals("The number of digits provided by expression was not sufficient or the unknown symbol provided instead of number", thrown.getMessage());
    }

    @Test
    void invalidExpressionOfOperator()  {
        var expression = "6 5 0 a *";
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new ExpressionEvaluator(expression).getResult();
        });
        Assertions.assertEquals("An invalid input in the sequence", thrown.getMessage());
    }

    @Test
    void invalidExpressionOfAnything()  {
        var expression = "6 5s 0 + *";
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new ExpressionEvaluator(expression).getResult();
        });
        Assertions.assertEquals("The number of digits provided by expression was not sufficient or the unknown symbol provided instead of number", thrown.getMessage());
    }

}
