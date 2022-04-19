package com.carbon.treasuresmap.services;

import com.carbon.treasuresmap.objects.Cell;
import com.carbon.treasuresmap.objects.Treasure;

import java.util.List;

public class TreasureService {
    public static void placeTreasures(List<Object> parsedMap, Cell[][] map) {
        for (Object obj : parsedMap) {
            if (obj instanceof Treasure) {
                Treasure trs = (Treasure) obj;
                map[trs.getX()][trs.getY()].setTreasure(trs);
            }
        }
    }
}