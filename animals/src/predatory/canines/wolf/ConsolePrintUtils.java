package predatory.canines.wolf;

public enum ConsolePrintUtils {
    NORMAL("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m");

    private final String code;

    ConsolePrintUtils(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
