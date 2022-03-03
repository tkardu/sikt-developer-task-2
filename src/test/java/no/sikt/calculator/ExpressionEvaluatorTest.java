package no.sikt.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionEvaluatorTest {

    @Test
    void shouldReturnValueWhenExpressionIsValid()  {
        var expected = 2;
        var expression = "1 1 +";
        var actual = new ExpressionEvaluator(expression).getResult();
        assertEquals(expected, actual);
    }
}
