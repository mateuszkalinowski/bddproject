package main;

public class DebitCard {
//
//    private boolean valid = true;

    private final Account account;
    private int pin;

    public DebitCard(Account account, int pin) {
        this.account = account;
        this.pin = pin;
    }

//    public boolean isValid() {
//        return valid;
//    }

    public boolean checkPin(int pin) {
        return this.pin == pin;
    }

    public Account getAccount() {
        return account;
    }
}