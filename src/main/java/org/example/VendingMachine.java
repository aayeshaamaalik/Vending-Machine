package org.example;

import java.util.*;

public class VendingMachine {
    private Stock stock;
    private List<Coin> insertedCoins;
    private float balance;

    public VendingMachine(Stock stock) {
        this.stock = stock;
        this.insertedCoins = new ArrayList<>();
        this.balance = 0;
    }

    // Insert coin into machine
    public void insertCoin(Coin coin) {
        insertedCoins.add(coin);
        balance += coin.getValue();
    }

    // Display current balance in dollars
    public float getCurrentBalance() {
        return balance / 100f;
    }

    // Select an item to purchase
    public Item selectItem(ItemInfo info) {
        float price = info.getPrice() * 100; // working in cents

        if (balance < price) {
            throw new NotEnoughMoneyException("Insufficient funds. Insert more coins.");
        }

        if (stock.getQty(info) == 0) {
            throw new NotEnoughItemException("Item out of stock.");
        }

        balance -= price;
        return stock.fetch(info);  // Dispense item
    }

    // Return change to user in coins
    public List<Coin> refundChange() {
        List<Coin> change = getChange((int) balance);
        insertedCoins.clear();
        balance = 0;
        return change;
    }

    // Utility: Calculate optimal change (using greedy approach)
    private List<Coin> getChange(int remainingCents) {
        List<Coin> change = new ArrayList<>();
        Coin[] coins = Coin.values();
        Arrays.sort(coins, (a, b) -> b.getValue() - a.getValue()); // Sort descending

        for (Coin coin : coins) {
            while (remainingCents >= coin.getValue()) {
                change.add(coin);
                remainingCents -= coin.getValue();
            }
        }
        return change;
    }
}

