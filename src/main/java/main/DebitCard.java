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

    public boolean changePin(int oldPin, int newPin) {
        if(checkPin(oldPin)) {
            if(String.valueOf(newPin).length() >=4 && String.valueOf(newPin).length() <=6) {
                pin = newPin;
                return true;
            }
            return false;
        }
        return false;
    }

    public int getPin() {
        return pin;
    }
}