package com.carbon.treasuresmap.services;

import com.carbon.treasuresmap.enums.Heading;
import com.carbon.treasuresmap.enums.Move;
import com.carbon.treasuresmap.objects.*;

import java.util.ArrayList;
import java.util.List;

public class MapParserService {

    public static List<Object> parseMap(List<String> lines) {

        List<Object> parsedMap = new ArrayList<>();
        for (String line : lines) {

            String[] lineComponents = line.split(" - ");
            String lineType = lineComponents[0];

            switch (lineType) {
                case "C":
                    MapSize mapSize = parseMapSize(lineComponents);
                    parsedMap.add(mapSize);
                    break;
                case "M":
                    Mountain mountain = parseMountain(lineComponents);
                    parsedMap.add(mountain);
                    break;
                case "T":
                    Treasure treasure = parseTreasure(lineComponents);
                    parsedMap.add(treasure);
                    break;
                case "A":
                    Adventurer adventurer = parseAdventurer(lineComponents);
                    parsedMap.add(adventurer);
                    break;
            }
        }

        return parsedMap;
    }

    public static MapSize parseMapSize(String[] lineComponents) {
        // Structure for a map line is "C - 3 - 4" : {C comme Carte} - {Nb. de case en largeur} - {Nb. de case en hauteur}

        int x = Integer.parseInt(lineComponents[1]);
        int y = Integer.parseInt(lineComponents[2]);
        return new MapSize(x, y);
    }

    public static Mountain parseMountain(String[] lineComponents) {
        // Structure for a map line is "M - 1 - 0" : {M comme Montagne} - {Axe horizontal} - {Axe vertical}

        int x = Integer.parseInt(lineComponents[1]);
        int y = Integer.parseInt(lineComponents[2]);
        return new Mountain(x, y);
    }

    public static Treasure parseTreasure(String[] lineComponents) {
        // Structure for a map line is "T - 0 - 3 - 2" : {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Nb. de trésors}

        int x = Integer.parseInt(lineComponents[1]);
        int y = Integer.parseInt(lineComponents[2]);
        int quantity = Integer.parseInt(lineComponents[3]);
        return new Treasure(x, y, quantity);
    }

    public static Adventurer parseAdventurer(String[] lineComponents) {
        // Structure for a map line is "A - Indiana - 1 - 1 - S - AADADA" : {A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe
        //vertical} - {Orientation} - {Séquence de mouvement}

        String name = lineComponents[1];
        int x = Integer.parseInt(lineComponents[2]);
        int y = Integer.parseInt(lineComponents[3]);
        Heading heading = Heading.valueOf(lineComponents[4]);
        List<Move> moves = parseAdventurerMoves(lineComponents[5].split(""));
        return new Adventurer(name, x, y, heading, moves);
    }

    public static List<Move> parseAdventurerMoves(String[] movesStringList) {
        List<Move> moves = new ArrayList<>();
        for (String move : movesStringList) {
            moves.add(Move.valueOf(move));
        }
        return moves;
    }

}
