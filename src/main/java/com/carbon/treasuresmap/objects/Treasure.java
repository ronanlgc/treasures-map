package com.carbon.treasuresmap.objects;

public class Treasure {

    private int x;
    private int y;
    private int quantity;

    public Treasure(int x, int y, int quantity) {
        this.x = x;
        this.y = y;
        this.quantity = quantity;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
