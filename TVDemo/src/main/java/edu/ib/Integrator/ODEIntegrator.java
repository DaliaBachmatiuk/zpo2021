package edu.ib.Integrator;

import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import org.codehaus.commons.compiler.CompileException;

import java.lang.reflect.InvocationTargetException;

public class ODEIntegrator {

    private double tLeft;
    private double tRight;
    private double x0;
    private ODEEquation ode;
    private ODEStep method;
    private StepHandler stepHandler;

    public ODEIntegrator(double tLeft, double tRight, double x0, ODEEquation ode, ODEStep method, StepHandler stepHandler) {
        this.tLeft = tLeft;
        this.tRight = tRight;
        this.x0 = x0;
        this.ode = ode;
        this.method = method;
        this.stepHandler = stepHandler;
    }

    public void integrate(double h) throws CompileException, InvocationTargetException, UnparsableExpressionException, UnknownFunctionException {
        double x = x0;
        double t;
        for (t = tLeft; t < tRight; t += h) {
            stepHandler.update(x,t);
            if (method.getClass() == Euler.class) x = method.step(x, t, h, ode);
            else {
                double xMid = x + method.step(x, t, h, ode) * h / 2;
                x = method.step(xMid, t, h, ode);
            }
        }
        stepHandler.update(x,t);
    }
}
