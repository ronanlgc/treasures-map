package com.carbon.treasuresmap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

    public static List<String> read(String path) throws FileNotFoundException {

        List<String> lines = new ArrayList<>();

//        InputStream in = InputReader.class.getResourceAsStream(path);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        File inputFile = new File(path);
        Scanner sc = new Scanner(inputFile);

        while (sc.hasNextLine())
            lines.add(sc.nextLine());
        return lines;
    }
}
