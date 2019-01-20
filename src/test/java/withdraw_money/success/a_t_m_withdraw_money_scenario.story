Narrative: Jako właściciel konta chce wypłacić pieniądze z bankomatu

Scenario: Na koncie są wystarczające środki
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









