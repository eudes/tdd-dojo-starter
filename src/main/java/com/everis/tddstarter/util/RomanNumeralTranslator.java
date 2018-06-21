package com.everis.tddstarter.util;

import java.util.HashMap;
import java.util.Map;

import com.everis.tddstarter.bean.UnitSystem;
import com.everis.tddstarter.exception.OutOfRangeException;

public class RomanNumeralTranslator {
    
    private static final int UNIT_BASE = 10;

    private static final Map<Integer, UnitSystem> systems = new HashMap<>();
    static {
        systems.put(10, new UnitSystem("I", "V", "X"));
        systems.put(100, new UnitSystem("X", "L", "C"));
        systems.put(1000, new UnitSystem("C", "D", "M"));
    }

    private static final int MAX_DIGITS = 3;
    private static final int MAX_POWER = power(UNIT_BASE, MAX_DIGITS);

    public static String translate(int number) {
        if(number <= 0 || number > 3999){
            throw new OutOfRangeException();
        }

        String translated = "";

        int currentDigitFromRight = 1;
        int currentDigitFactor = UNIT_BASE;
        do {
            UnitSystem unitSystem = systems.get(currentDigitFactor);
            int currentDigit = extractCurrentDigit(number, currentDigitFactor);

            translated = buildUnits(currentDigit, unitSystem) + translated;
            currentDigitFromRight +=1;

            if(number < currentDigitFactor){
                break;
            }
            currentDigitFactor = currentDigitFactor*UNIT_BASE;
        }
        // limited to MAX_DIGITS
        while(currentDigitFromRight <= MAX_DIGITS);

        // just add the thousands (MAX_POWER) numeral to the left
        int thousandsDigit = extractCurrentDigit(number, MAX_POWER*UNIT_BASE);
        translated = repeatNumeral(systems.get(MAX_POWER).getNextUnit(), thousandsDigit) + translated;
        
        return translated;
    }

    /**
     * Builds numeral for the digit, from 0 to UNIT_BASE-1.
     * 
     */
    private static String buildUnits(int digit, UnitSystem unitSystem){
        String currentUnitNumeral = unitSystem.getUnit();
        int middlePoint = UNIT_BASE / 2;

        int modulo = digit % middlePoint;
        int middlePointTimes = digit / middlePoint;

        String nextUnitNumeral = "";
        String nextNextUnitNumeral = unitSystem.getMiddle();

        // if we are past the middle point
        if( middlePointTimes % 2 != 0 ){
            nextUnitNumeral = unitSystem.getMiddle();
            nextNextUnitNumeral = unitSystem.getNextUnit();
        }

        if(modulo == (middlePoint- 1)){
            return currentUnitNumeral + nextNextUnitNumeral;
        } else {
            return nextUnitNumeral + repeatNumeral(currentUnitNumeral, modulo);
        }
    }

    private static int extractCurrentDigit(int number, int currentDigitFactor){
        int currentDigit = (number % currentDigitFactor);
        if((currentDigitFactor/UNIT_BASE) > 0){
            currentDigit = currentDigit / (currentDigitFactor/UNIT_BASE);
        }
        return currentDigit;
    }

    private static String repeatNumeral(String numeral, int times){
        String result = "";
        for (int i = 0; i < times; i++) {
            result += numeral;
        }
        return result;
    }

    private static int power(int base, int power){
        return (new Double(Math.pow(base, power))).intValue();
    }

}