Narrative: Jako właściciel konta chce wpłacić pieniądze na moje konto

Scenario: Wpłata pieniędzy do bankomatu
Given stan konta to <account_balance>
Given karta z pinem <card_pin>
When bankomat ma miejsce na <atm_capacity>
When właściciel konta chce wpłacić <request>
Then bankomat powinien przyjac <result>
Then bankomat powinien miec dostepne <atmAvailableAfterTransaction>
Then stan konta powinien być równy <newBalance>

Examples:
|account_balance|card_pin |atm_capacity|request|result |atmAvailableAfterTransaction|newBalance|
|100            |1234     |40          |20     |20     |20                          |120       |
|100            |1234     |40          |10     |10     |10                          |110       |
|0              |1234     |100         |400    |0      |0                           |0         |