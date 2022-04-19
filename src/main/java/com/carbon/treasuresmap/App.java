package com.carbon.treasuresmap;

import com.carbon.treasuresmap.objects.Adventurer;
import com.carbon.treasuresmap.objects.Cell;
import com.carbon.treasuresmap.services.AdventurerService;
import com.carbon.treasuresmap.services.MapParserService;
import com.carbon.treasuresmap.services.MapService;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        List<String> lines = InputReader.read("src/main/resources/map.txt");
        List<Object> parsedStringsMap = MapParserService.parseMap(lines);
        Cell[][] map = MapService.create(parsedStringsMap);
        List<Adventurer> adventurers = AdventurerService.initAdventurers(parsedStringsMap, map);
        AdventurerService.playMoves(adventurers, map);
        OutputWriter.writeOutputToFile(parsedStringsMap, "src/main/output/file.txt");
        List<String> outputLines = InputReader.read("src/main/output/file.txt");

        for (String line : outputLines) {
            System.out.println(line);
        }
    }
}
