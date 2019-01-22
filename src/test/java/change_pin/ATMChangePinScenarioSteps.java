package change_pin;


import main.ATM;
import main.Account;
import main.DebitCard;
import org.jbehave.core.annotations.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ATMChangePinScenarioSteps {

    private ATM atm;
    private Account account;
    private DebitCard debitCard;

    private int providedPin;

    private int money;

    private int newPin1;

    private int newPin2;


    @BeforeStory
    public void createAtm(){
        atm = new ATM(0,0);
    }


    @Given("stan konta to <account_balance>")
    public void createAccount(@Named("account_balance") int balance) {
        account = new Account(balance);
    }

    @Given("karta z pinem <card_pin>")
    public void createDebitCard(@Named("card_pin") int card_pin) {
        debitCard = new DebitCard(account,card_pin);
    }

    @When("właściciel konta podaje pin <provided_card_pin>")
    public void providePin(@Named("provided_card_pin") int providedPin) { this.providedPin = providedPin; }

    @When("właściciel konta chce zmienić pin, podaje nowy pin <new_pin1>")
    public void changePin(@Named("new_pin1") int newPin1) {
        this.newPin1 = newPin1;
    }

    @When("właściciel konta chce zmienic pin, ponownie podaje nowy pin <new_pin2>")
    public void inputNewPin(@Named("new_pin2") int newPin2) {
        this.newPin2 = newPin2;
    }

    @Then("bankomat ustawia pin na nowy <final_pin>")
    public void checkMoney(@Named("final_pin") int finalPin) {
        assertThat(finalPin,is(this.atm.changePin(debitCard,providedPin,newPin1,newPin2)));
    }

    @Then("stan konta powinien byc rowny <new_balance>")
    public void checkBalance(@Named("new_balance") int balance) {
        assertThat(balance, is(debitCard.getAccount().getBalance()));
    }
}
