package com.carbon.treasuresmap;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InputReaderTest {
    
  @Test
  public void shouldReturnCorrectLines() throws IOException {

    List<String> testLines = new ArrayList<>();
    testLines.add("C - 4 - 5");
    testLines.add("M - 0 - 0");
    testLines.add("M - 1 - 1");
    testLines.add("M - 2 - 4");
    List<String> readLines = InputReader.read();

    assertEquals(4, readLines.size());
    assertTrue(readLines.get(0).equalsIgnoreCase(testLines.get(0)));
    assertTrue(readLines.get(1).equalsIgnoreCase(testLines.get(1)));
    assertTrue(readLines.get(2).equalsIgnoreCase(testLines.get(2)));
    assertTrue(readLines.get(3).equalsIgnoreCase(testLines.get(3)));
  }
}
