package no.sikt.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionEvaluatorTest {

    @Test
    void shouldReturnValueWhenExpressionIsValid() {
        var expected = 6;
        var expression = "3 1 / 2 *";
        var actual = new ExpressionEvaluator(expression).getResult();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnValueWhenExpressionIsValidandResIsZero() {
        var expected = 0;
        var expression = "0 3 4 + 2 1 + + /";
        var actual = new ExpressionEvaluator(expression).getResult();
        assertEquals(expected, actual);
    }


    @Test
    void zeroDivisionCausedByExpression() {
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
            new ExpressionEvaluator(expression);
        });
    }

    @Test
    void notEnoughNumbers() {
        var expression = "2 3 + *";
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new ExpressionEvaluator(expression);
        });
        Assertions.assertEquals("The number of digits provided by expression was not sufficient or the unknown symbol provided instead of number", thrown.getMessage());
    }

    @Test
    void invalidExpressionOfOperator() {
        var expression = "6 5 0 a *";
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new ExpressionEvaluator(expression);
        });
        Assertions.assertEquals("An invalid input in the sequence", thrown.getMessage());
    }

    @Test
    void invalidExpressionOfAnything() {
        var expression = "6 5s 0 + *";
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new ExpressionEvaluator(expression);
        });
        Assertions.assertEquals("The number of digits provided by expression was not sufficient or the unknown symbol provided instead of number", thrown.getMessage());
    }


    /* TODO Not sure how to implement looping through examples without parameterized test, but junit dependency is not there?
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.8.1</version>
    <scope>test</scope>
</dependency>*/
    /*
    public static ArrayList<String[]> readFile(File test2) throws IOException {
        ArrayList<String[]> TestData = new ArrayList<>();
        try (BufferedReader TSVReader = new BufferedReader(new FileReader(test2))) {
            String line = null;
            while ((line = TSVReader.readLine()) != null) {
                String[] lineItems = line.split("\t");
                TestData.add(lineItems);
            }
            return TestData;
        }
    }*/
}
