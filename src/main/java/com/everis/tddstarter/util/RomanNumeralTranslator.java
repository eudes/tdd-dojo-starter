package com.everis.tddstarter.util;

import com.everis.tddstarter.exception.OutOfRangeException;

public class RomanNumeralTranslator {

    private static final int BASE = 5; 

    public static String translate(int number) throws OutOfRangeException{
        if(number <= 0 || number > 35){
            throw new OutOfRangeException();
        }

        int modulo = number % BASE;
        int baseTimes = number / BASE;
        int tens = number / (BASE * 2);

        return repeatNumeral("X", tens) + buildUnits(modulo, baseTimes);
    }

    /**
     * Build the units for the numeral, from 0 to BASE.
     * 
     */
    private static String buildUnits(int modulo, int baseTimes){
        String numeral = "";
        String nextNumeral = "V";

        // even number of bases
        if( baseTimes % 2 != 0 ){
            numeral = "V";
            nextNumeral = "X";
        }

        if(modulo == (BASE- 1)){
            return "I" + nextNumeral;
        } else {
            String translated = "";
            for (int i = 0; i < modulo; i++) {
                translated += "I";
            }
            return numeral + translated;
        }
    }

    private static String repeatNumeral(String numeral, int times){
        String result = "";
        for (int i = 0; i < times; i++) {
            result += numeral;
        }
        return result;
    }

}