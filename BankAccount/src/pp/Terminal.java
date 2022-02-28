package pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

public class Terminal {
    public void payOut(BankAccount bankAccount, BigDecimal sum, PaymentType type) throws IOException {
        if (isScaleValid(sum)) {
            sum = sum.round(new MathContext(2, RoundingMode.UP));
        }

        if (isSumNegative(sum)) {
            System.out.println("Kwota nie może być liczbą ujemną");
            return;
        }

        if (type == PaymentType.BLIK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            long startTime = System.currentTimeMillis();

            int blik = 0;
            Random random = new Random();

            for (int i = 0; i < 7; i++) {
                blik += random.nextInt(10) * Math.pow(10, i);
            }

            System.out.println("Twój kod blik: ");
            System.out.println(blik);

            while((System.currentTimeMillis() - startTime) < 10 * 1000 && !reader.ready()) {}

            if(!reader.ready()) {
                System.out.println("Czas minął. Nie udało się wypłacić blikiem.");
                return;
            }

            if (Integer.parseInt(reader.readLine()) != blik) {
                System.out.println("Zły kod blik. Nie udąło się wypłacić");
                return;
            }
        }

        if (type == PaymentType.BLIK) type = PaymentType.DEBIT;

        if (bankAccount.checkBalance(sum, type)) {
            bankAccount.setBalance(sum.negate());
            System.out.println("✓");
        }
    }

    private boolean isScaleValid(BigDecimal sum){
        return sum.scale() > 2;
    }

    private boolean isSumNegative(BigDecimal sum){
        return sum.compareTo(new BigDecimal("0")) < 0;
    }
}
