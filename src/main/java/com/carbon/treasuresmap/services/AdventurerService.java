package com.carbon.treasuresmap.services;

import com.carbon.treasuresmap.enums.Heading;
import com.carbon.treasuresmap.enums.Move;
import com.carbon.treasuresmap.objects.Adventurer;
import com.carbon.treasuresmap.objects.Cell;

import java.util.ArrayList;
import java.util.List;

public class AdventurerService {
    public static List<Adventurer> initAdventurers(List<Object> parsedMap, Cell[][] map) {
        List<Adventurer> adventurersList = new ArrayList<>();
        for (Object obj : parsedMap) {
            if (obj instanceof Adventurer) {
                Adventurer adv = (Adventurer) obj;
                map[adv.getX()][adv.getY()].setAdventurer(adv);
                adventurersList.add(adv);
            }
        }
        return adventurersList;
    }

    public static void playMoves(List<Adventurer> adventurers, Cell[][] map) {
        int maxSizeList = 0;
        for (Adventurer adventurer : adventurers) {
            if (adventurer.getMoves().size() > maxSizeList) {
                maxSizeList = adventurer.getMoves().size();
            }
        }

        for (int i = 0; i < maxSizeList; i++) {
            for (Adventurer adventurer : adventurers) {
                int currentListSize = adventurer.getMoves().size();
                if (i < currentListSize) {
                    Move move = adventurer.getMoves().get(i);
                    doMoves(adventurer, move, map);
                }
            }
        }
    }

    private static void doMoves(Adventurer adventurer, Move move, Cell[][] map) {
        if (move.equals(Move.valueOf("A"))) {
            moveForward(adventurer, map);
        } else if (move.equals(Move.valueOf("G"))) {
            turnLeft(adventurer);
        } else if (move.equals(Move.valueOf("D"))) {
            turnRight(adventurer);
        }
    }

    private static void moveForward(Adventurer adventurer, Cell[][] map) {
        List<Integer> nextPosition = getNextPosition(adventurer);
        if (CellService.verifyMapLimits(nextPosition, map)) {
            Cell currentCell = map[adventurer.getX()][adventurer.getY()];
            Cell nextCell = map[nextPosition.get(0)][nextPosition.get(1)];

            if (CellService.verifyAccessibility(nextCell)) {
                currentCell.setAdventurer(null);
                adventurer.setX(nextPosition.get(0));
                adventurer.setY(nextPosition.get(1));
                nextCell.setAdventurer(adventurer);
                if (nextCell.getTreasure() != null) //noinspection SuspiciousIndentAfterControlStatement
                {
                    if (nextCell.getTreasure().getQuantity() > 0)
                        adventurer.setGatheredTreasures(adventurer.getGatheredTreasures() + 1);
                        nextCell.getTreasure().setQuantity(nextCell.getTreasure().getQuantity() - 1);
                }
            }
        }
    }

    private static void turnLeft(Adventurer adventurer) {
        switch (adventurer.getHeading()) {
            case N:
                adventurer.setHeading(Heading.O);
                break;
            case S:
                adventurer.setHeading(Heading.E);
                break;
            case O:
                adventurer.setHeading(Heading.S);
                break;
            case E:
                adventurer.setHeading(Heading.N);
                break;
        }
    }

    private static void turnRight(Adventurer adventurer) {
        switch (adventurer.getHeading()) {
            case N:
                adventurer.setHeading(Heading.E);
                break;
            case S:
                adventurer.setHeading(Heading.O);
                break;
            case O:
                adventurer.setHeading(Heading.N);
                break;
            case E:
                adventurer.setHeading(Heading.S);
                break;
        }
    }

    private static List<Integer> getNextPosition(Adventurer adventurer) {
        List<Integer> nextPosition = new ArrayList<>();
        List<Integer> currentPosition = new ArrayList<>();
        currentPosition.add(adventurer.getX());
        currentPosition.add(adventurer.getY());
        switch (adventurer.getHeading()) {
            case N:
                nextPosition.add(currentPosition.get(0));
                nextPosition.add(currentPosition.get(1) - 1);
                break;
            case S:
                nextPosition.add(currentPosition.get(0));
                nextPosition.add(currentPosition.get(1) + 1);
                break;
            case O:
                nextPosition.add(currentPosition.get(0) - 1);
                nextPosition.add(currentPosition.get(1));
                break;
            case E:
                nextPosition.add(currentPosition.get(0) + 1);
                nextPosition.add(currentPosition.get(1));
                break;
        }
        return nextPosition;
    }
}