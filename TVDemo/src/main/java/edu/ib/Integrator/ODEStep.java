package edu.ib.Integrator;

import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import org.codehaus.commons.compiler.CompileException;

import java.lang.reflect.InvocationTargetException;

public interface ODEStep {
    double step(double x, double t, double h, ODEEquation ode) throws CompileException, InvocationTargetException, UnparsableExpressionException, UnknownFunctionException;
}
