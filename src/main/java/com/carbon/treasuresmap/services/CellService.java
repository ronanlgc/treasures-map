package com.carbon.treasuresmap.services;

import com.carbon.treasuresmap.objects.Cell;
import java.util.List;

public class CellService {

    public static boolean verifyMapLimits(List<Integer> position, Cell[][] map) {
        int width = map.length;
        int height = map[0].length;
        int x = position.get(0);
        int y = position.get(1);
        return 0 <= x && x < width && 0 <= y && y < height;
    }

    public static boolean verifyAccessibility(Cell cell) {
        return (cell.getAdventurer() == null && !cell.getMountain());
    }
}
