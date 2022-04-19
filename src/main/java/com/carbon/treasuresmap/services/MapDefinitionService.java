package com.carbon.treasuresmap.services;

import com.carbon.treasuresmap.objects.MapSize;

import java.util.List;

public class MapDefinitionService {
    public static MapSize getMapDefinition(List<Object> parsedMap) {
        MapSize mapSize = null;
        for (Object obj : parsedMap) {
            if (obj instanceof MapSize) {
                mapSize = (MapSize) obj;
            }
        }
        return mapSize;
    }
}