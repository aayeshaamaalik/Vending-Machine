
---

# Vending Machine System

This project implements a **Vending Machine System** using clean object-oriented design principles. The machine supports coin insertion, item selection, inventory tracking, transaction execution, and change refunds.

**Design Reference:**  
This design is modeled on the [Vending Machine system from ycwkatie's OOD repository](https://github.com/ycwkatie/OOD-Object-Oriented-Design/blob/main/ood/vending_machine.md).

---

## Key Components and Interacting Objects

| Class / Interface              | Responsibility                                                                 |
|--------------------------------|---------------------------------------------------------------------------------|
| `Coin`                         | Enum representing supported currency denominations.                            |
| `ItemInfo`, `Item`             | `ItemInfo` holds item metadata (price); `Item` represents a physical product. |
| `Stock`                        | Manages inventory: adding, fetching, reducing items.                          |
| `VendingMachine`               | Orchestrates vending logic: coin handling, item dispensing, change refund.    |
| `NotEnoughMoneyException`      | Thrown when balance is insufficient for selected item.                        |
| `NotEnoughItemException`       | Thrown when the selected item is out of stock.                                |

---

## Class Hierarchy and Design

```
Coin (enum)
   ├── PENNY, NICKLE, DIME, QUARTER, DOLLAR, LOONIE

ItemInfo
   └── price (float)

Item
   └── wraps ItemInfo

Stock
   └── Map<ItemInfo, List<Item>>

VendingMachine
   ├── List<Coin> insertedCoins
   ├── float balance
   ├── Stock stock
   ├── insertCoin(), selectItem(), refundChange()

Exceptions
   ├── NotEnoughMoneyException
   └── NotEnoughItemException
```

---

## Supported Functionalities

1. **Insert Coins**  
   Users can insert coins of supported types to accumulate balance.

2. **Check Current Balance**  
   The current balance is displayed in dollars (internally tracked in cents).

3. **Select an Item**  
   Users select an item to purchase. If funds are insufficient or the item is out of stock, relevant exceptions are thrown.

4. **Dispense Item**  
   On successful purchase, the item is dispensed and the balance is updated.

5. **Refund Change**  
   Users can cancel a transaction and retrieve their remaining balance in coins.

---

## Getting Started

To set up and run the project locally:

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/vending-machine-system.git
   ```

2. Navigate into the project directory:
   ```bash
   cd vending-machine-system
   ```

3. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

4. Compile and run the system.  
   Ensure your environment supports **Java 8+**.

---

## Project Structure

| Package / Class Group      | Responsibility                                               |
|----------------------------|---------------------------------------------------------------|
| `model/payment`            | `Coin` enum                                                   |
| `model/product`            | `ItemInfo`, `Item`, `Stock` classes                           |
| `controller`               | `VendingMachine` — the main logic class                       |
| `exception`                | Custom exceptions: `NotEnoughMoneyException`, `NotEnoughItemException` |

---
