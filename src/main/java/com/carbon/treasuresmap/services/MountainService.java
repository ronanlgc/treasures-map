package com.carbon.treasuresmap.services;

import com.carbon.treasuresmap.objects.Cell;
import com.carbon.treasuresmap.objects.Mountain;

import java.util.List;

public class MountainService {
    public static void placeMountains(List<Object> parsedMap, Cell[][] map) {
        for (Object obj : parsedMap) {
            if (obj instanceof Mountain) {
                Mountain mnt = (Mountain) obj;
                map[mnt.getX()][mnt.getY()].setMountain(true);
            }
        }
    }
}