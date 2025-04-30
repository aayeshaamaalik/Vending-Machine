package org.example;
import java.util.*;

public class Stock {
    private Map<ItemInfo, List<Item>> stock;

    public Stock() {
        this.stock = new HashMap<>();
    }

    // Get current quantity of a specific item type
    public int getQty(ItemInfo info) {
        return stock.getOrDefault(info, Collections.emptyList()).size();
    }

    // Add an item to stock
    public void add(Item item) {
        stock.computeIfAbsent(item.getInfo(), k -> new ArrayList<>()).add(item);
    }

    // Reduce stock by one item (used when a user buys an item)
    public void reduce(ItemInfo info) {
        List<Item> items = stock.get(info);
        if (items == null || items.isEmpty()) {
            throw new NoSuchElementException("Item out of stock");
        }
        items.remove(items.size() - 1);  // Remove last item
    }

    // Fetch one item (used in executeTransaction)
    public Item fetch(ItemInfo info) {
        List<Item> items = stock.get(info);
        if (items == null || items.isEmpty()) {
            throw new NoSuchElementException("Item out of stock");
        }
        return items.remove(items.size() - 1);
    }
}

