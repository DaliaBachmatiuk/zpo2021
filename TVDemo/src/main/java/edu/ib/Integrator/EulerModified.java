package edu.ib.Integrator;

import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import org.codehaus.commons.compiler.CompileException;

import java.lang.reflect.InvocationTargetException;

public class EulerModified implements ODEStep{
    @Override
    public double step(double x, double t, double h, ODEEquation ode) throws UnparsableExpressionException, UnknownFunctionException, CompileException, InvocationTargetException {
        return ode.f(x, t + h / 2) * h;
    }
}

