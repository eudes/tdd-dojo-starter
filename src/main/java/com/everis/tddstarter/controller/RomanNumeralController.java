package com.everis.tddstarter.controller;

import com.everis.tddstarter.util.RomanNumeralTranslator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RomanNumeralController {

    @RequestMapping(value = "/roman/{number}", method = RequestMethod.POST)
    public String translate(@PathVariable("number") Long number) {
        return RomanNumeralTranslator.translate(number);
    }

}