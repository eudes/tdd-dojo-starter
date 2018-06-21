package com.everis.tddstarter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.everis.tddstarter.exception.OutOfRangeException;
import com.everis.tddstarter.util.RomanNumeralTranslator;

import org.junit.Test;

public class RomanNumeralTranslatorTest {

	@Test
	public void testTranslate() {
		assertEquals("1 should translate to I", "I", RomanNumeralTranslator.translate(1));
		assertEquals("2 should translate to II", "II", RomanNumeralTranslator.translate(2));
		assertEquals("3 should translate to III", "III", RomanNumeralTranslator.translate(3));
		assertEquals("4 should translate to IV", "IV", RomanNumeralTranslator.translate(4));
		assertEquals("5 should translate to V", "V", RomanNumeralTranslator.translate(5));
		assertEquals("6 should translate to VI", "VI", RomanNumeralTranslator.translate(6));
		assertEquals("7 should translate to VII", "VII", RomanNumeralTranslator.translate(7));
		assertEquals("8 should translate to VIII", "VIII", RomanNumeralTranslator.translate(8));
		assertEquals("9 should translate to IX", "IX", RomanNumeralTranslator.translate(9));
		assertEquals("10 should translate to X", "X", RomanNumeralTranslator.translate(10));

		assertEquals("11 should translate to XI", "XI", RomanNumeralTranslator.translate(11));
		assertEquals("12 should translate to XII", "XII", RomanNumeralTranslator.translate(12));
		assertEquals("15 should translate to XV", "XV", RomanNumeralTranslator.translate(15));
		assertEquals("14 should translate to XIV", "XIV", RomanNumeralTranslator.translate(14));
		assertEquals("19 should translate to XIX", "XIX", RomanNumeralTranslator.translate(19));

		assertEquals("31 should translate to XXXI", "XXXI", RomanNumeralTranslator.translate(31));
		assertEquals("34 should translate to XXXIV", "XXXIV", RomanNumeralTranslator.translate(34));
		assertEquals("35 should translate to XXXV", "XXXV", RomanNumeralTranslator.translate(35));
	}

	@Test
	public void test100(){
		assertEquals("1000 should translate to X", "M", RomanNumeralTranslator.translate(1000));
		assertEquals("49 should translate to X", "XLIX", RomanNumeralTranslator.translate(49));
		assertEquals("10 should translate to X", "X", RomanNumeralTranslator.translate(10));
		assertEquals("50 should translate to X", "L", RomanNumeralTranslator.translate(50));
		assertEquals("100 should translate to X", "C", RomanNumeralTranslator.translate(100));

		assertEquals("3999 should translate to X", "MMMCMXCIX", RomanNumeralTranslator.translate(3999));
	}

	@Test
	public void testExceptions(){
		try{
			RomanNumeralTranslator.translate(0);
			fail("0 should throw");
		} catch (OutOfRangeException e){
			boolean isOutOfRangeException = e instanceof OutOfRangeException;
			assertTrue("Exception should be OutOfRangeException", isOutOfRangeException);
		}

		try{
			RomanNumeralTranslator.translate(4000);
			fail("4000 should throw");
		} catch (OutOfRangeException e){
			boolean isOutOfRangeException = e instanceof OutOfRangeException;
			assertTrue("Exception should be OutOfRangeException", isOutOfRangeException);
		}
	}

}
