package deposit_money.success;


import main.ATM;
import main.Account;
import main.DebitCard;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ATMDepositMoneyScenarioSteps {

    private ATM atm;
    private Account account;
    private DebitCard debitCard;

    private int money;

    @Given("stan konta to <account_balance>")
    public void createAccount(@Named("account_balance") int balance) {
        account = new Account(balance);
    }

    @When("karta jest wazna")
    public void createCreditCard() {
        debitCard = new DebitCard(account);
    }

    @When("bankomat ma miejsce na <atm_capacity>")
    public void createATM(@Named("atm_capacity") int capacity) {
        atm = new ATM(0,capacity);
    }

    @When("właściciel konta chce wpłacić <request>")
    public void withdrawMoney(@Named("request") int amount) {
        money = atm.depositMoney(debitCard, amount);
    }

    @Then("bankomat powinien przyjac <result>")
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
