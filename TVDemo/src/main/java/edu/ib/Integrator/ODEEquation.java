package edu.ib.Integrator;

import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import org.codehaus.commons.compiler.CompileException;

import java.lang.reflect.InvocationTargetException;

public interface ODEEquation {
    double f(double x, double t) throws CompileException, InvocationTargetException, UnparsableExpressionException, UnknownFunctionException;
}
