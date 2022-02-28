package pp;

import java.math.BigDecimal;

public class BankAccount {
    private BigDecimal balance;
    private boolean isCreditCardActive = false;
    private BigDecimal creditCardLimit = new BigDecimal("0");

    public boolean checkBalance(BigDecimal sum, PaymentType type) {
        boolean truefalse = true;
        switch (type) {
            case DEBIT-> {
                if (balance.subtract(sum).compareTo(new BigDecimal("0")) < 0) {
                System.out.println("Nie można wypłacić, brak środków na koncie.");
                truefalse = false;
                }
            }
            case CREDIT -> {
                if (!isCreditCardActive) {
                    System.out.println("Karta kredytowa jest nieaktywna");
                    truefalse = false;
                    break;
                }
                if (balance.subtract(sum).compareTo(creditCardLimit.negate()) < 0) {
                    System.out.println("Lmit przekroczony, nie można wypłacić.");
                    truefalse = false;
                }
            }
        }
        return truefalse;
    }

    void setBalance(BigDecimal sum) {
        this.balance = balance.add(sum);
    }

    public void createCreditCard(BigDecimal limit){
        setCreditCardLimit(limit);
        if (creditCardLimit.compareTo(new BigDecimal(0)) == 0) {
            this.isCreditCardActive = false;
            System.out.println("Błędny limit. Karta nie została utoworzona.");
        }
        System.out.println("Karta utworzona.");
        this.isCreditCardActive = true;
    }

    public void setCreditCardLimit(BigDecimal creditCardLimit){
        if (creditCardLimit.compareTo(new BigDecimal("5000")) > 0){
            System.out.println("Przepraszamy, maksymalny limit to 5000");
            return;
        }
        this.creditCardLimit = creditCardLimit;
    }

    public BigDecimal getCreditCardLimit(){
        return creditCardLimit;
    }

    public BigDecimal getBalance() {
        if (balance == null) this.balance = new BigDecimal("0.00");
        return balance;
    }
}

