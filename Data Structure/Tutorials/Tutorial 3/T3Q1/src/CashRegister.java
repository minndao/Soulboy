public class CashRegister {

    private double remainingBalance;

    CashRegister() {
        remainingBalance = 0;
    }

    CashRegister(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    acceptCash(double payment) {
        remainingBalance += payment;
    }
}
