package com.heavyweightsoftware.romannumeralconverter;

import java.io.*;
import java.net.URL;

public class Main {
    public static final String fileName = "/romanNumerals.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = openInputFile(fileName);
        String line = "";
        while ((line = reader.readLine()) != null) {
            RomanNumeral romanNumeral = new RomanNumeral(line);
            System.out.print(line);
            System.out.print('\t');
            System.out.println(romanNumeral.getValue());
        }

        reader.close();
    }

    private static BufferedReader openInputFile(String fileName) throws FileNotFoundException {
        URL url = Main.class.getResource(fileName);
        if (url == null) {
            throw new FileNotFoundException(fileName);
        }

        File file = new File(url.getFile());
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
}
