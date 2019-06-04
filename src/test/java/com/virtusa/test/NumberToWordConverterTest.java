package com.virtusa.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class NumberToWordConverterTest {

    private NumberToWordConverter converter;

    private Map<Integer, String> expectedResults = new LinkedHashMap<Integer, String>() {
        {
            put(0, "Zero");
            put(1, "One");
            put(99, "Ninety Nine");
            put(100, "One Hundred");
            put(999, "Nine Hundred and Ninety Nine");
            put(1000, "One Thousand");
            put(9999, "Nine Thousand Nine Hundred and Ninety Nine");
            put(10000, "Ten Thousand");
            put(99999, "Ninety Nine Thousand Nine Hundred and Ninety Nine");
            put(999999, "Nine Hundred and Ninety Nine Thousand Nine Hundred and Ninety Nine");
            put(56945781, "Fifty Six Million Nine Hundred and Forty Five Thousand Seven Hundred and Eighty One");
            put(999999999, "Nine Hundred and Ninety Nine Million Nine Hundred and Ninety Nine Thousand Nine Hundred and Ninety Nine");
            put(246864256, "Two Hundred and Forty Six Million Eight Hundred and Sixty Four Thousand Two Hundred and Fifty Six");
            put(931945251, "Nine Hundred and Thirty One Million Nine Hundred and Forty Five Thousand Two Hundred and Fifty One");
            put(461450510, "Four Hundred and Sixty One Million Four Hundred and Fifty Thousand Five Hundred and Ten");
            put(280765944, "Two Hundred and Eighty Million Seven Hundred and Sixty Five Thousand Nine Hundred and Forty Four");
            put(843919757, "Eight Hundred and Forty Three Million Nine Hundred and Nineteen Thousand Seven Hundred and Fifty Seven");
            put(27903936, "Twenty Seven Million Nine Hundred and Three Thousand Nine Hundred and Thirty Six");
            put(539123533, "Five Hundred and Thirty Nine Million One Hundred and Twenty Three Thousand Five Hundred and Thirty Three");
            put(13595904, "Thirteen Million Five Hundred and Ninety Five Thousand Nine Hundred and Four");
            put(467257040, "Four Hundred and Sixty Seven Million Two Hundred and Fifty Seven Thousand Forty");
            put(179242024, "One Hundred and Seventy Nine Million Two Hundred and Forty Two Thousand Twenty Four");
            put(262269097, "Two Hundred and Sixty Two Million Two Hundred and Sixty Nine Thousand Ninety Seven");
        }
    };

    @Before
    public void setUp() {
        converter = new NumberToWordConverter();
    }

    @Test
    public void testConvertNumToWordSuccess() throws Exception {
        for (Map.Entry<Integer, String> entry : expectedResults.entrySet()) {
            String actual = converter.convertNumToWord(entry.getKey());
            Assert.assertEquals(entry.getValue(), actual);

        }

    }

    @Test(expected = Exception.class)
    public void testConvertNumToWordFailure() throws Exception {
        converter.convertNumToWord(2147483647);

    }


    @Test(expected = Exception.class)
    public void testConvertNumToWordFailure1() throws Exception {
        converter.convertNumToWord(-101);

    }
}

