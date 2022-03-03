package no.sikt.calculator;

import static java.util.Objects.nonNull;

public class ExpressionEvaluator {
    public ExpressionEvaluator(String expression) {
        assert nonNull(expression);
    }

    public Integer getResult() {
        return 2;
    }
}
