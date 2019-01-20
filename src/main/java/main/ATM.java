package main;

public class ATM {

    private int money;

    private int capacity;

    public ATM(int money,int capacity) {
        this.money = money;
        this.capacity = capacity;
    }

    /**
     *
     * @param debitCard Karta płatnicza użyta do operacji
     * @param amount Ilość pieniędzy do wypłaty
     * @return Ilość pieniędzy jaką udało się wypłacić
     */
    public int withdrawMoney(DebitCard debitCard, int amount) {
        if (!debitCard.isValid() || amount > money) {
            return 0;
        }

        amount = debitCard.getAccount().getMoney(amount);

        money = money - amount;

        return amount;
    }

    /**
     *
     * @param debitCard Karta płatnicza użyta do operacji
     * @param amount Ilość pieniędzy do wpłaty
     * @return Ilość pieniędzy jaką udało się wpłacić
     */
    public int depositMoney(DebitCard debitCard, int amount) {
        if( !debitCard.isValid() || money + amount > capacity) {
            return 0;
        }

        amount = debitCard.getAccount().putMoney(amount);

        money = money + amount;

        return amount;
    }

    public int getAtmMoney(){
        return money;
    }
}