package predatory.canines.wolf;

public class Spleen implements IMeasurable {
    private final double thickness;
    private final double length;
    private final double width;

    public Spleen(double thickness, double length, double width) {
        if (thickness < 0) {
            System.out.println("Wrong number. It has to be positive.");
            thickness = 0;
        }
        if (length < 0) {
            System.out.println("Wrong number. It has to be positive.");
            length = 0;
        }
        if (width < 0) {
            System.out.println("Wrong number. It has to be positive.");
            width = 0;
        }
        this.thickness = thickness;
        this.length = length;
        this.width = width;
    }

    public double splenicIndex() {
        return thickness * length * width;
    }

    public String getData() {
        return ConsolePrintUtils.BLUE.getCode() + "thickness: " + thickness + ConsolePrintUtils.GREEN.getCode() + ", length:  " + length + ConsolePrintUtils.RED.getCode() + ", width: " + width + ConsolePrintUtils.NORMAL.getCode();
    }

    @Override
    public double getMeasure() {
        return 30 + 0.58 * splenicIndex();
    }
}
