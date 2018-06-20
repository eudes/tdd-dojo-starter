package com.everis.tddstarter;

import static org.junit.Assert.assertEquals;

import com.everis.tddstarter.util.RomanNumeralTranslator;

import org.junit.Test;

public class RomanNumeralTranslatorTest {

	@Test
	public void testTranslate() {

		assertEquals("1 should translate to I", "I", RomanNumeralTranslator.translate(1));

	}

}
