# ATM System Low Level Design (LLD)

This diagram represents the **class-level design** of an ATM system.  
It includes the controller, hardware devices, transactions, and strategy patterns for cash dispensing.

## 📌 Class Diagram

```mermaid
classDiagram
class AtmController {
    +CardReader cardReader
    +Dispenser dispenser
    +Keyboard keyboard
    +Printer printer
    +Screen screen
    +startSession()
    +executeTransaction()
    +endSession()
}

%% ---- Devices ----
class CardReader {
    +inject()
    +validate()
    +eject()
}

class Dispenser {
    +HashMap~Denomination,int~ cashInventory
    +DispenserStrategy strategy
    +cashAvailable()
    +dispense(amount)
    +reloadCash()
}

class Printer {
    +printTransactionDetails()
    +printError()
}

class Screen {
    +displayMessage()
    +displayError()
}

class Keyboard {
    <<Interface>>
    +getInput()
    +getPin()
    +selectTransaction()
}
class Physical
class Digital

%% ---- Dispenser Strategies ----
class DispenserStrategy {
    <<Interface>>
    +dispenseAmount(amount)
}
class CoinChange
class MinimizeEveryNote

%% ---- Transactions ----
class Transactions {
    <<abstract>>
    +makeTransaction()
}
class Withdraw
class BankStatement
class CheckBalance

class BankServer {
    +validateCard()
    +getBalance()
    +debitAccount()
    +creditAccount()
}

%% ---- Relationships ----
AtmController *-- CardReader
AtmController *-- Dispenser
AtmController *-- Keyboard
AtmController *-- Printer
AtmController *-- Screen

Keyboard <|.. Physical
Keyboard <|.. Digital

Dispenser *-- DispenserStrategy
DispenserStrategy <|.. CoinChange
DispenserStrategy <|.. MinimizeEveryNote

Transactions <|.. Withdraw
Transactions <|.. BankStatement
Transactions <|.. CheckBalance
Transactions --> BankServer


