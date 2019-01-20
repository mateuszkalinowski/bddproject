package main;

public class DebitCard {

    private boolean valid = true;

    private final Account account;

    public DebitCard(Account account) {
        this.account = account;
    }

    public boolean isValid() {
        return valid;
    }

    public Account getAccount() {
        return account;
    }
}