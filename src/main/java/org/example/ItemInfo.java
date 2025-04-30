package org.example;

public class ItemInfo {
    private float price;

    public ItemInfo(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemInfo)) return false;
        ItemInfo other = (ItemInfo) obj;
        return Float.compare(other.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Float.hashCode(price);
    }
}
