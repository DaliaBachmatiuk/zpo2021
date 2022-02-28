import pp.ATM;
import pp.BankAccount;
import pp.PaymentType;
import pp.Terminal;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {
        BankAccount account = new BankAccount();
        Terminal terminal = new Terminal();
        ATM atm = new ATM();

        BigDecimal balanceToDeposit = new BigDecimal("365.87");
        BigDecimal balanceToWithdrawal = new BigDecimal("50.60");
        BigDecimal balanceToPayOut = new BigDecimal("223.4");
        BigDecimal tooBigBalanceToPayOut = new BigDecimal("300");
        BigDecimal wrongScale = new BigDecimal("24.9876");
        BigDecimal negative = new BigDecimal("-180.65");

        //Sprawdzenie, czy stan początkowy konta przy jego utworzeniu wynosi 0
        System.out.println(account.getBalance() + "\n");

        //Wpłata
        atm.deposit(account, balanceToDeposit);
        System.out.println(account.getBalance() + "\n");

        //Wypłata
        atm.withdrawal(account, balanceToWithdrawal);
        System.out.println(account.getBalance() + "\n");

        //Płatność kartą
        terminal.payOut(account, balanceToPayOut,  PaymentType.DEBIT);
        System.out.println(account.getBalance() + "\n");

        //Sprawdzenie ewentualnych błedów przy płatności kartą debetową
        terminal.payOut(account, tooBigBalanceToPayOut, PaymentType.DEBIT);
        System.out.println(account.getBalance() + "\n");

        terminal.payOut(account, wrongScale, PaymentType.DEBIT);
        System.out.println(account.getBalance() + "\n");

        terminal.payOut(account, negative, PaymentType.DEBIT);
        System.out.println(account.getBalance() + "\n");

        //Sprawdzenie ewentualnych błedów przy wypłacaniu
        atm.deposit(account, wrongScale);
        System.out.println(account.getBalance() + "\n");

        atm.deposit(account, negative);
        System.out.println(account.getBalance() + "\n");

        //Płacenie kartą kredytową
        //Próba bez posiadania karty
        terminal.payOut(account, balanceToPayOut, PaymentType.CREDIT);
        System.out.println(account.getBalance() + "\n");

        //Tworzenie karty kredytowej
        account.createCreditCard(new BigDecimal(6000));
        System.out.println(account.getBalance() + "\n");

        account.createCreditCard(new BigDecimal(5000));
        System.out.println(account.getBalance() + "\n");

        //Utworzenie nowego limitu
        account.setCreditCardLimit(new BigDecimal("500"));
        System.out.println(account.getCreditCardLimit());

        //Próba z posiadaniem karty z ustawionym limitem
        terminal.payOut(account, tooBigBalanceToPayOut, PaymentType.CREDIT);
        System.out.println(account.getBalance() + "\n");

        //Sprawdzamy, czy mimo stanu na minusie można wypłacić normalnie
        terminal.payOut(account, tooBigBalanceToPayOut, PaymentType.CREDIT);
        System.out.println(account.getBalance());
        System.out.println(account.getBalance() + "\n");

        //Blik bez środków
        terminal.payOut(account, new BigDecimal("100"), PaymentType.BLIK);
        System.out.println(account.getBalance());
        System.out.println(account.getBalance() + "\n");

        //Blik
        atm.deposit(account, new BigDecimal("1300"));
        terminal.payOut(account, new BigDecimal("1000"), PaymentType.BLIK);
        System.out.println(account.getBalance());
    }
}
