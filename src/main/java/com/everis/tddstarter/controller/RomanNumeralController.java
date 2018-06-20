package com.everis.tddstarter.controller;

import com.everis.tddstarter.exception.OutOfRangeException;
import com.everis.tddstarter.util.RomanNumeralTranslator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RomanNumeralController {

    @RequestMapping(value = "/roman/{number}", method = RequestMethod.GET)
    public String translate(@PathVariable("number") Integer number) throws OutOfRangeException{
        return RomanNumeralTranslator.translate(number);
    }

}