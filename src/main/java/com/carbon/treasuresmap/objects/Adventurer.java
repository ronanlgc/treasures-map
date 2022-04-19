package com.carbon.treasuresmap.objects;

import com.carbon.treasuresmap.enums.Heading;
import com.carbon.treasuresmap.enums.Move;

import java.util.List;

public class Adventurer {

    private String name;

    private int gatheredTreasures;
    private int x;
    private int y;
    private Heading heading;
    private List<Move> moves;

    public Adventurer(String name, int x, int y, Heading heading, List<Move> moves) {
        this.name = name;
        this.gatheredTreasures = 0;
        this.x = x;
        this.y = y;
        this.heading = heading;
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGatheredTreasures() {
        return gatheredTreasures;
    }

    public void setGatheredTreasures(int gatheredTreasures) {
        this.gatheredTreasures = gatheredTreasures;
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

    public Heading getHeading() {
        return heading;
    }

    public void setHeading(Heading heading) {
        this.heading = heading;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
}
