Narrative: Jako właściciel konta chce wypłacić pieniądze z bankomatu

Scenario: Wypłata pieniędzy z bankomatu
Given stan konta to <account_balance>
When karta jest wazna
When bankomat ma dostępne <atm_available>
When wlasciciel konta chce wyplacic <request>
Then bankomat powinien wypłacić <result>
Then bankomat powinien miec dostepne <atmAvailableAfterTransaction>
Then stan konta powinien być równy <newBalance>


Examples:
|account_balance|atm_available|request|result|atmAvailableAfterTransaction|newBalance|
|100            |200          |20     |20    |180                         |80        |
|100            |200          |10     |10    |190                         |90        |
|100            |200          |150    |0     |200                         |100       |
|100            |50           |80     |0     |50                          |100       |








