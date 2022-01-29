package edu.ib.Integrator;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

public class Function implements ODEEquation {
    private final ExpressionBuilder expressionBuilder;

    public Function(String function) {
        expressionBuilder = new ExpressionBuilder(function);
    }

    @Override
    public double f(double x, double t) throws UnparsableExpressionException, UnknownFunctionException {
        Calculable calc = expressionBuilder.withVariable("t", t).build();
        return calc.calculate();
    }
}
