package no.sikt.calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Arrays;

import static java.util.Objects.nonNull;

public class ExpressionEvaluator {
    Integer result;
    public ExpressionEvaluator(String expression) {
        assert nonNull(expression);
            this.result = processExpression(expression);
    }

   public Integer processExpression (String expression){
       Stack<Integer> stackedValues = new Stack<Integer>();
       String[] tokenized = expression.split(" ");
       for (String element : tokenized) {
           assert nonNull(element);
           try
           {
               Integer.valueOf(element);
               stackedValues.push(Integer.valueOf(element));
           }
           catch (NumberFormatException e)
           {
               stackOperation(element, stackedValues);
           }

       }
       if (stackedValues.size() == 1){
           return stackedValues.peek();
       }
       else {
           throw new IllegalArgumentException("An operator is missing");
       }
   }


    public Stack<Integer> stackOperation(String operation, Stack<Integer> stackCalculator) {
        int value1;
        int value2;
        try {
            value2 = stackCalculator.pop();
            value1 = stackCalculator.pop();
        }
        catch (EmptyStackException errStack){
            throw new IllegalArgumentException("The number of digits provided by expression was not sufficient or the unknown symbol provided instead of number");
        }

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
            throw new IllegalArgumentException("An invalid input in the sequence");
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

