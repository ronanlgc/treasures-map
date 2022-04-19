package com.carbon.treasuresmap.services;

import com.carbon.treasuresmap.objects.*;

import java.util.List;

public class MapService {

    public static Cell[][] create(List<Object> parsedMap) {

        MapSize mapSize = MapDefinitionService.getMapDefinition(parsedMap);
        Cell[][] map = new Cell[mapSize.getWidth()][mapSize.getHeight()];
        initialize(map, mapSize);
        MountainService.placeMountains(parsedMap, map);
        TreasureService.placeTreasures(parsedMap, map);
        return map;
    }

    public static void initialize(Cell[][] map, MapSize mapSize) {
        for (int i = 0; i < mapSize.getWidth(); i++) {
            for (int j = 0; j < mapSize.getHeight(); j++) {
                map[i][j] = new Cell(i, j);
            }
        }
    }


}
