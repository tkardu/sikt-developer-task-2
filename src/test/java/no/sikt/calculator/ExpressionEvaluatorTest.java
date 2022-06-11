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
    void emptyExpression()  {
        var expression = "";
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            new ExpressionEvaluator(expression).getResult();
        });
    }
}
