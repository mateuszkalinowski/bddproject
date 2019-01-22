package main;

public class ATM {

    private int money;

    private int capacity;

    public ATM(int money,int capacity) {
        this.money = money;
        this.capacity = capacity;
    }

    public int withdrawMoney(DebitCard debitCard, int amount, int pin) {
        if (amount > money || !debitCard.checkPin(pin)) {
            return 0;
        }

        amount = debitCard.getAccount().getMoney(amount);

        money = money - amount;

        return amount;
    }

    public int depositMoney(DebitCard debitCard, int amount) {
        if( money + amount > capacity) {
            return 0;
        }

        amount = debitCard.getAccount().putMoney(amount);

        money = money + amount;

        return amount;
    }

    public int changePin(DebitCard debitCard, int oldPin, int newPin1, int newPin2) {
        if(newPin1 != newPin2)
            return debitCard.getPin();
        if(!debitCard.checkPin(oldPin))
            return debitCard.getPin();
        if(debitCard.changePin(oldPin,newPin1))
            return newPin1;
        else
            return debitCard.getPin();
    }

    public int getAtmMoney(){
        return money;
    }
}