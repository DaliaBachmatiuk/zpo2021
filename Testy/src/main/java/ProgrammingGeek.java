
public class ProgrammingGeek implements IProgrammingGeek{
    @Override
    public boolean isPerfect(int number) {
        int sum = 1;
        for(int i = 2; i <= Math.sqrt(number); i++)
        {
            if (number % i == 0){
                sum += i;
                sum += number / i;
            }
        }
        return number > 1 && sum == number;
    }

    @Override
    public String changeToCamelCase(String originalSentence) throws Exception {
        if (originalSentence.isEmpty() || originalSentence.isBlank()) throw new Exception("There is no sequence");

        String[] divided = originalSentence.toLowerCase().split(" ");
        StringBuilder camelCase = new StringBuilder();

        for (int i = 0; i < divided.length; i++) {
            for (int j = 0; j < divided[i].length(); j++) {
                if (divided[i].charAt(j) == ',' || divided[i].charAt(j) == '.')  break;
                if (j == 0 && i > 0) camelCase.append(divided[i].toUpperCase().charAt(0));
                else camelCase.append(divided[i].charAt(j));
            }
        }
        return camelCase.toString();
    }

    @Override
    public int getFactorial(int number) throws Exception {
        if (number < 0) throw new Exception("Number has to be positive.");
        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
