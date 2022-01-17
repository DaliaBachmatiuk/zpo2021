package pp;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ATM {
    public void deposit(BankAccount bankAccount, BigDecimal sum) {
        if (isScaleValid(sum)) {
            sum = sum.round(new MathContext(2, RoundingMode.UP));
        }

        if (isSumNegative(sum)) {
            System.out.println("Kwota nie może być liczbą ujemną");
            return;
        }
        bankAccount.setBalance(sum);
    }

    public void withdrawal(BankAccount bankAccount, BigDecimal sum) {
        if (isScaleValid(sum)) {
            sum = sum.round(new MathContext(2, RoundingMode.UP));
        }

        if (isSumNegative(sum)) {
            System.out.println("Kwota nie może być liczbą ujemną");
            return;
        }
        bankAccount.setBalance(sum.negate());
    }

    private boolean isScaleValid(BigDecimal sum){
        return sum.scale() > 2;
    }

    private boolean isSumNegative(BigDecimal sum){
        return sum.compareTo(new BigDecimal("0")) < 0;
    }
}
