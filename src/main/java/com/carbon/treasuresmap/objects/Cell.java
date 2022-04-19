package com.carbon.treasuresmap.objects;

public class Cell {

    private int x;
    private int y;
    private Treasure treasure;
    private Adventurer adventurer;
    private Boolean mountain;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.mountain = false;
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

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }

    public Boolean getMountain() {
        return mountain;
    }

    public void setMountain(Boolean mountain) {
        this.mountain = mountain;
    }
}
