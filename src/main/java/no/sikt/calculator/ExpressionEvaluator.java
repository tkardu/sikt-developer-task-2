package no.sikt.calculator;

import java.util.Stack;
import java.util.Arrays;

import static java.util.Objects.nonNull;

public class ExpressionEvaluator {
    Integer result;
    public ExpressionEvaluator(String expression) {
        assert nonNull(expression);
        try
        {
            this.result = processExpression(expression);
        }
        catch (Exception e) {

        }
    }

   public Integer processExpression (String expression){
       Stack<Integer> stackedValues = new Stack<Integer>();
       String[] tokenized = expression.split(" ");
       for (String element : tokenized) {
           assert nonNull(element);
           if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
               stackOperation(element, stackedValues);

           } else {
                   stackedValues.push(Integer.valueOf(element));
                   //throws an exception
           }
       }
       if (stackedValues.size() == 1){
           return stackedValues.peek();
       }
       else {
           throw new IndexOutOfBoundsException("Stack size after processing is not 1");
       }
   }


    public Stack<Integer> stackOperation(String operation, Stack<Integer> stackCalculator) {
        int value2 = stackCalculator.pop();
        int value1 = stackCalculator.pop();
        int operationResult;
        if (operation.equals("+")) {
            operationResult = value1 + value2;
        } else if (operation.equals("-")) {
            operationResult = value1 - value2;
        } else if (operation.equals("/")) {
            if (value2 != 0) {
                operationResult = value1 / value2;
            }
            else{
                throw new ArithmeticException("The operation value sequence lead to zero division");
            }
        } else if (operation.equals("*")) {
            operationResult = value1 * value2;
        }
        else {
            throw new RuntimeException("An operation was processed wrong");
        }
        //TOdo: handle wrong operator
        stackCalculator.push(operationResult);
        return stackCalculator;
    }

    public Integer getResult() {
        assert nonNull(this.result);
        return this.result;
    }
}

