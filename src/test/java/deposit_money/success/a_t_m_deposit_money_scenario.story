Narrative: Jako właściciel konta chce wypłacić pieniądze z bankomatu

Scenario: W bankomacie jest wystarczająca ilość miejsca
Given stan konta to <account_balance>
When karta jest wazna
When bankomat ma miejsce na <atm_capacity>
When właściciel konta chce wpłacić <request>
Then bankomat powinien przyjac <result>
Then bankomat powinien miec dostepne <atmAvailableAfterTransaction>
Then stan konta powinien być równy <newBalance>

Examples:
|account_balance|atm_capacity|request|result |atmAvailableAfterTransaction|newBalance|
|100            |40          |20     |20     |20                          |120       |
|100            |40          |10     |10     |10                          |110       |
