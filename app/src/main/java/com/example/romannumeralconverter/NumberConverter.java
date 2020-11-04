package com.example.romannumeralconverter;

import java.util.HashMap;

public class NumberConverter {

    public String toRoman(int number) {

        if (number <= 0) {
            return "Number must be greater than zero";
        }
        else if (number > 10000) {
            return "Number must be less than 10000";
        }

        String convertedValue = "";

        while (number >= 1000) {
            convertedValue += "M";
            number = number - 1000;
        }
        while (number >= 900) {
            convertedValue += "CM";
            number = number - 900;
        }
        while (number >= 500) {
            convertedValue += "D";
            number = number - 500;
        }
        while (number >= 400) {
            convertedValue += "CD";
            number = number - 400;
        }
        while (number >= 100) {
            convertedValue += "C";
            number = number - 100;
        }
        while (number >= 90) {
            convertedValue += "XC";
            number = number - 90;
        }
        while (number >= 50) {
            convertedValue += "L";
            number = number - 50;
        }
        while (number >= 40) {
            convertedValue += "XL";
            number = number - 40;
        }
        while (number >= 10) {
            convertedValue += "X";
            number = number - 10;
        }
        while (number >= 9) {
            convertedValue += "IX";
            number = number - 9;
        }
        while (number >= 5) {
            convertedValue += "V";
            number = number - 5;
        }
        while (number >= 4) {
            convertedValue += "IV";
            number = number - 4;
        }
        while (number >= 1) {
            convertedValue += "I";
            number = number - 1;
        }

        //Return string value for numeral
        return convertedValue;
    }

    public int toNumber(String numeral) {



        //Converts each character to uppercase to work with
        String romanNumeral = numeral.toUpperCase();

        //Hash map to store the values of Roman numerals
        HashMap<Character, Integer> romanMap = new HashMap<>();

        //filling the map with paired values
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int len = romanNumeral.length();
        int result = romanMap.get(romanNumeral.charAt(len-1));

        //Loop through the string in reverse to make the conversion easier
        for (int i = len - 2; i >= 0; i--) {
            if (romanMap.get(romanNumeral.charAt(i)) >= romanMap.get(romanNumeral.charAt(i + 1))) {
                result += romanMap.get(romanNumeral.charAt(i));
            }
            else {
                result -= romanMap.get(romanNumeral.charAt(i));
            }

        }
        return result;
    }
}
