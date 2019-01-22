Narrative: Jako właściciel konta chce zmienić pin mojej karty

Scenario: Zmiana pinu
Given stan konta to <account_balance>
Given karta z pinem <card_pin>
When właściciel konta podaje pin <provided_card_pin>
When właściciel konta chce zmienić pin, podaje nowy pin <new_pin1>
When właściciel konta chce zmienic pin, ponownie podaje nowy pin <new_pin2>
Then bankomat ustawia pin na nowy <final_pin>
Then stan konta powinien byc rowny <new_balance>


Examples:
|account_balance|card_pin |provided_card_pin |new_pin1|new_pin2|final_pin|new_balance|
|200            |1234     |1234              |4321    |4321    |4321     |200        |
|200            |1234     |1111              |4321    |4321    |1234     |200        |
|200            |1234     |1234              |4321    |4322    |1234     |200        |









