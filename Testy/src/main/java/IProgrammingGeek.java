/**
 *
 */
public interface IProgrammingGeek {

    /**
     * @param number Number to check
     * @return if the number is perfect
     */
    boolean isPerfect(int number);

    /**
     * @param originalSentence Original sentence to convert to camelCase
     * @return Original statement camelCase representation
     */
    String changeToCamelCase(String originalSentence) throws Exception;

    /**
     * @param number Number to calculate factorial
     * @return Factorial of given number
     */
    int getFactorial(int number) throws Exception;
}
