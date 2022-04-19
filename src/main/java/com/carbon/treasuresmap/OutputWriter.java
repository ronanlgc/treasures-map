package com.carbon.treasuresmap;

import com.carbon.treasuresmap.objects.Adventurer;
import com.carbon.treasuresmap.objects.MapSize;
import com.carbon.treasuresmap.objects.Mountain;
import com.carbon.treasuresmap.objects.Treasure;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OutputWriter {

    public static void writeOutputToFile(List<Object> objectsList, String path) throws IOException {
        java.io.FileWriter writer = new java.io.FileWriter(path);
        PrintWriter printWriter = new PrintWriter(writer);

        for (Object obj : objectsList) {
            if (obj instanceof MapSize) {
                MapSize mapSize = (MapSize) obj;
                printWriter.println(
                        "C - " + mapSize.getWidth() + " - " + mapSize.getHeight()
                );
            }
            if (obj instanceof Mountain) {
                Mountain mountain = (Mountain) obj;
                printWriter.println(
                        "M - " + mountain.getX() + " - " + mountain.getY()
                );
            }
            if (obj instanceof Treasure) {
                Treasure treasure = (Treasure) obj;
                printWriter.println(
                        "T - " + treasure.getX() + " - " + treasure.getY() + " - " + treasure.getQuantity()
                );
            }
            if (obj instanceof Adventurer) {
                Adventurer adventurer = (Adventurer) obj;
                printWriter.println(
                        "A - " + adventurer.getName() + " - " + adventurer.getX() + " - " + adventurer.getY() + " - " + adventurer.getHeading() + " - " + adventurer.getGatheredTreasures()
                );
            }
        }
        printWriter.close();
    }

}
