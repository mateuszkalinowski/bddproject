package withdraw_money;


import main.ATM;
import main.Account;
import main.DebitCard;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ATMWithdrawMoneyScenarioSteps {

    private ATM atm;
    private Account account;
    private DebitCard debitCard;

    private int providedPin;

    private int money;

    @Given("stan konta to <account_balance>")
    public void createAccount(@Named("account_balance") int balance) {
        account = new Account(balance);
    }

    @Given("karta z pinem <card_pin>")
    public void createDebitCard(@Named("card_pin") int card_pin) {
        debitCard = new DebitCard(account,card_pin);
    }

    @When("bankomat ma dostępne <atm_available>")
    public void createATM(@Named("atm_available") int money) {
        atm = new ATM(money,money);
    }

    @When("właściciel konta podaje pin <provided_card_pin>")
    public void providePin(@Named("provided_card_pin") int providedPin) { this.providedPin = providedPin; }

    @When("wlasciciel konta chce wyplacic <request>")
    public void withdrawMoney(@Named("request") int amount) {
        money = atm.withdrawMoney(debitCard, amount, providedPin);
    }

    @Then("bankomat powinien wypłacić <result>")
    public void checkMoney(@Named("result") int amount) {
        assertThat(money, is(amount));
    }

    @Then("bankomat powinien miec dostepne <atmAvailableAfterTransaction>")
    public void checkAtmAfterTransaction(@Named("atmAvailableAfterTransaction") int atmMoney) {
        assertThat(atmMoney,is(atm.getAtmMoney()));
    }

    @Then("stan konta powinien być równy <newBalance>")
    public void checkBalance(@Named("newBalance") int balance) {
        assertThat(balance, is(debitCard.getAccount().getBalance()));
    }
}
