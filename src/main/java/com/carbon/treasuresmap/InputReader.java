package com.carbon.treasuresmap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

    public static List<String> read() throws IOException {

        List<String> lines = new ArrayList<>();
        try (InputStream is = InputReader.class.getClassLoader().getResourceAsStream("map.txt")) {
            Scanner sc = new Scanner(is);
            while (sc.hasNextLine())
                lines.add(sc.nextLine());
        }
//        File inputFile = new File(path);

        return lines;
    }
}
