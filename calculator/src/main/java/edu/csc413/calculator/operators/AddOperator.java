package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;
import edu.csc413.calculator.operators.Operator;

public class AddOperator extends Operator {
    @Override
    public int priority() {
        return 1;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        return null;
    }
}
