package com.everis.tddstarter;

import static org.junit.Assert.assertEquals;

import com.everis.tddstarter.util.RomanNumeralTranslator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TddStarterApplicationTests {

	@Test
	public void testTranslate() {

		assertEquals("1 should translate to I", "I", RomanNumeralTranslator.translate(1L));

	}

}
