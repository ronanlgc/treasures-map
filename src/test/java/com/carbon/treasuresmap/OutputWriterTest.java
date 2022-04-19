package com.carbon.treasuresmap;

import com.carbon.treasuresmap.objects.MapSize;
import com.carbon.treasuresmap.objects.Mountain;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OutputWriterTest {
    @Test
    public void shouldWriteOutputToFile() throws IOException {

        List<Object> objectList = new ArrayList<>();
        MapSize mapSize = new MapSize(2, 4);
        Mountain mountain = new Mountain(1,2);
        objectList.add(mapSize);
        objectList.add(mountain);

        List<String> testLines = new ArrayList<>();
        testLines.add("C - 2 - 4");
        testLines.add("M - 1 - 2");

        OutputWriter.writeOutputToFile(objectList, "src/test/resources/outputTest.txt");

        List<String> readLines = InputReader.read("src/test/resources/outputTest.txt");

        assertEquals(2, readLines.size());
        assertTrue(readLines.get(0).equalsIgnoreCase(testLines.get(0)));
        assertTrue(readLines.get(1).equalsIgnoreCase(testLines.get(1)));
    }
}
