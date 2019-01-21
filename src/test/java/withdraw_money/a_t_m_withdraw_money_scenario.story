Narrative: Jako właściciel konta chce wypłacić pieniądze z bankomatu

Scenario: Wypłata pieniędzy z bankomatu
Given stan konta to <account_balance>
Given karta z pinem <card_pin>
When bankomat ma dostępne <atm_available>
When właściciel konta podaje pin <provided_card_pin>
When wlasciciel konta chce wyplacic <request>
Then bankomat powinien wypłacić <result>
Then bankomat powinien miec dostepne <atmAvailableAfterTransaction>
Then stan konta powinien być równy <newBalance>


Examples:
|account_balance|card_pin |atm_available|provided_card_pin  |request|result|atmAvailableAfterTransaction|newBalance|
|100            |1234     |200          |1234               |20     |20    |180                         |80        |
|100            |1234     |200          |1234               |10     |10    |190                         |90        |
|100            |1234     |200          |1234               |150    |0     |200                         |100       |
|100            |1234     |50           |1234               |80     |0     |50                          |100       |
|100            |1234     |200          |9999               |80     |0     |200                         |100       |








