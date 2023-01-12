package com.heavyweightsoftware.romannumeralconverter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {
    public static final String ROM_NUM_1000 = "M";
    public static final String ROM_NUM_900 = "CM";
    public static final String ROM_NUM_500 = "D";
    public static final String ROM_NUM_400 = "CD";
    public static final String ROM_NUM_100 = "C";
    public static final String ROM_NUM_90 = "XC";
    public static final String ROM_NUM_50 = "L";
    public static final String ROM_NUM_40 = "XL";
    public static final String ROM_NUM_10 = "X";
    public static final String ROM_NUM_9 = "IX";
    public static final String ROM_NUM_5 = "V";
    public static final String ROM_NUM_4 = "IV";
    public static final String ROM_NUM_1 = "I";

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
        int idx = 0;
        char ch;
        char lastChar = Character.MAX_VALUE;
        int result = 0;
        boolean done = false;

        while (!done) {
            ch = romanNumeral.charAt(idx);
            int val = getNumeralValue(ch);

            if (compare(lastChar, ch) < 0) {
                result -= (getNumeralValue(lastChar) * 2);
            }
            else {
                result += val;
                idx++;
            }
            lastChar = ch;

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

    @Override
    public String toString() {
        return toString(value);
    }

    public static String toString(int val) {
        StringBuilder sb = new StringBuilder(10);
        int num = val;

        while(num > 0) {
            if (num >= 1000) {
                sb.append(ROM_NUM_1000);
                num -= 1000;
            }
            else if (num >= 900) {
                sb.append(ROM_NUM_900);
                num -= 900;
            }
            else if (num >= 500) {
                sb.append(ROM_NUM_500);
                num -= 500;
            }
            else if (num >= 400) {
                sb.append(ROM_NUM_400);
                num -= 400;
            }
            else if (num >= 100) {
                sb.append(ROM_NUM_100);
                num -= 100;
            }
            else if (num >= 90) {
                sb.append(ROM_NUM_90);
                num -= 90;
            }
            else if (num >= 50) {
                sb.append(ROM_NUM_50);
                num -= 50;
            }
            else if (num >= 40) {
                sb.append(ROM_NUM_40);
                num -= 40;
            }
            else if (num >= 10) {
                sb.append(ROM_NUM_10);
                num -= 10;
            }
            else if (num >= 9) {
                sb.append(ROM_NUM_9);
                num -= 9;
            }
            else if (num >= 5) {
                sb.append(ROM_NUM_5);
                num -= 5;
            }
            else if (num >= 4) {
                sb.append(ROM_NUM_4);
                num -= 4;
            }
            else if (num >= 1) {
                sb.append(ROM_NUM_1);
                num -= 1;
            }
        }

        return sb.toString();
    }
}
