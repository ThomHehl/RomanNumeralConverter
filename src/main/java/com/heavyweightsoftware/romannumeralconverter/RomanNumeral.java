package com.heavyweightsoftware.romannumeralconverter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {
    private static final Map<Character, Integer> characterValues = new HashMap<>();

    static {
        characterValues.put('I', 1);
        characterValues.put('V', 5);
        characterValues.put('X', 10);
        characterValues.put('L', 50);
        characterValues.put('C', 100);
        characterValues.put('D', 500);
        characterValues.put('M', 1000);
    }

    private int value;

    public RomanNumeral(String romanNumeral) {
        value = parseValue(romanNumeral);
    }

    public int getValue() {
        return value;
    }

    public static int getNumeralValue(char romNum) {
        int result = 0;

        Integer val = characterValues.get(romNum);
        if (val != null) {
            result = val;
        }

        return result;
    }

    public static int parseValue(String romanNumeral) {
        final int stateIncreasing = 0;
        final int stateDecreasing = 1;
        int state = stateIncreasing;
        int idx = 0;
        int decreasingUntil = -1;
        char ch;
        char lastChar = Character.MAX_VALUE;
        int result = 0;
        boolean done = false;

        while (!done) {
            ch = romanNumeral.charAt(idx);
            int val = getNumeralValue(ch);

            switch (state) {
                case stateIncreasing -> {
                    if (compare(lastChar, ch) < 0) {
                        state = stateDecreasing;
                        result -= getNumeralValue(lastChar);
                        decreasingUntil = idx;
                        idx--;
                    }
                    else {
                        result += val;
                        idx++;
                    }
                    lastChar = ch;
                }

                case stateDecreasing -> {
                    if (idx < decreasingUntil) {
                        result -= getNumeralValue(ch);
                        idx++;
                    }
                    else {
                        state = stateIncreasing;
                    }
                }
            }

            if (idx >= romanNumeral.length()) {
                done = true;
            }
        }

        return result;
    }

    protected static int compare(char c1, char c2) {
        int val1 = getNumeralValue(c1);
        if (val1 == 0) {
            val1 = Integer.MAX_VALUE;
        }

        int val2 = getNumeralValue(c2);

        int result = val1 - val2;

        return result;
    }
}
