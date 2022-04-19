package com.carbon.treasuresmap.services;

import com.carbon.treasuresmap.enums.Move;
import com.carbon.treasuresmap.objects.Adventurer;
import com.carbon.treasuresmap.objects.Cell;
import com.carbon.treasuresmap.objects.MapSize;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.carbon.treasuresmap.enums.Heading.E;
import static com.carbon.treasuresmap.enums.Heading.N;
import static com.carbon.treasuresmap.enums.Move.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventurerServiceTest {

    private final List<Move> movesList1 = Arrays.asList(G, A, D, A);
    private final List<Move> movesList2 = Arrays.asList(A, A, D, D);
    private final Adventurer adventurer1 = new Adventurer("Butters", 1, 1, E, movesList1);
    private final Adventurer adventurer2 = new Adventurer("Kyle", 2, 3, N, movesList2);
    private final MapSize mapSize = new MapSize(4,5);

    @Test
    public void shouldReturnAdventurers(){
        List<Object> parsedMap = Arrays.asList(mapSize,adventurer1, adventurer2);
        Cell[][] map= MapService.create(parsedMap);
        List<Adventurer> adventurerList = AdventurerService.initAdventurers(parsedMap, map);

        assertEquals(2, adventurerList.size());
        assertEquals("Butters", adventurerList.get(0).getName());
        assertEquals(2, adventurerList.get(1).getX());
        assertEquals(1, adventurerList.get(0).getY());
        assertEquals(N, adventurerList.get(1).getHeading());
    }

    @Test
    public void shouldMoveCorrectly(){
        List<Object> parsedMap = Arrays.asList(mapSize,adventurer1);
        Cell[][] map= MapService.create(parsedMap);
        List<Adventurer> adventurerList = AdventurerService.initAdventurers(parsedMap, map);

        AdventurerService.playMoves(adventurerList, map);

        assertEquals(2,adventurerList.get(0).getX());
        assertEquals(0,adventurerList.get(0).getY());
    }
}
