package com.carbon.treasuresmap.services;

import com.carbon.treasuresmap.enums.Move;
import com.carbon.treasuresmap.objects.Adventurer;
import com.carbon.treasuresmap.objects.MapSize;
import com.carbon.treasuresmap.objects.Mountain;
import com.carbon.treasuresmap.objects.Treasure;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static com.carbon.treasuresmap.enums.Heading.O;
import static com.carbon.treasuresmap.enums.Move.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapParserServiceTest {

    @Test
    public void shouldParseMapSize(){
        String[] lineComponents = {"C", "2", "4"};
        MapSize mapSize = MapParserService.parseMapSize(lineComponents);

        assertEquals(2, mapSize.getWidth());
        assertEquals(4, mapSize.getHeight());
    }

    @Test
    public void shouldParseMountain(){
        String[] lineComponents = {"M", "1", "1"};
        Mountain mountain = MapParserService.parseMountain(lineComponents);

        assertEquals(1, mountain.getX());
        assertEquals(1, mountain.getY());
    }

    @Test
    public void shouldParseTreasure(){
        String[] lineComponents = {"T", "3", "3", "2"};
        Treasure treasure = MapParserService.parseTreasure(lineComponents);

        assertEquals(3, treasure.getX());
        assertEquals(3, treasure.getY());
        assertEquals(2, treasure.getQuantity());
    }

    @Test
    public void shouldParseAdventurer(){
        String[] lineComponents = {"A", "Joe", "1", "1", "O", "GADA"};
        Adventurer adventurer = MapParserService.parseAdventurer(lineComponents);
        List<Move> movesList = Arrays.asList(G, A, D, A);

        assertEquals("Joe", adventurer.getName());
        assertEquals(1, adventurer.getX());
        assertEquals(1, adventurer.getY());
        assertEquals(O,adventurer.getHeading());
        assertEquals(movesList, adventurer.getMoves());
    }
}
