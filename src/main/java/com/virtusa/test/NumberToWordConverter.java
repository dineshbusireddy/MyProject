package com.virtusa.test;

import java.util.function.Predicate;

public class NumberToWordConverter {
    public static final String[] SCALE_UNITS = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    public static final String[] SCALE_UNITS_TENS = {
            "",
            "",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };

    private static final String EMPTY = "";
    private static final String SPACE = " ";
    private static final String AND = " and ";
    private static final int ZERO = 0;
    private static final String ZERO_STRING = "Zero";
    private static final int TWENTY = 20;
    private static final int HUNDRED = 100;
    private static final String HUNDRED_STRING = "Hundred";
    private static final int TEN = 10;
    private static final int THOUSAND = 1000;
    private static final int MILLION = 1000000;
    private static final String THOUSAND_STRING = "Thousand";
    private static final int MAX_INPUT = 999999999;
    private static final String MILLION_STRING = "Million";
    private static final String INVALID = "Invalid Input";


    public String convertNumToWord(final int input) throws Exception{
        if (input == ZERO) {
            return ZERO_STRING;
        } else if (input < ZERO) {
            throw new Exception(INVALID);
        }

        return convert(input);

    }
    private String convert(final int input) throws Exception {
        if (input < TWENTY) {
            return SCALE_UNITS[input];
        }

        if (input < HUNDRED) {
            return SCALE_UNITS_TENS[input / TEN] + getUnit((in) -> in % TEN == ZERO, input, null) + SCALE_UNITS[input % TEN];
        }

        if (input < THOUSAND) {
            return SCALE_UNITS[input / HUNDRED] + getUnit((in) -> in % HUNDRED == ZERO, input, HUNDRED_STRING) +  convert(input % HUNDRED);
        }

        if (input < MILLION) {
            return convert(input / THOUSAND) + getUnit((in) -> in % THOUSAND == ZERO, input, THOUSAND_STRING) + convert(input % THOUSAND);
        }

        if (input <= MAX_INPUT) {
            return convert(input / MILLION) + getUnit((in) -> in % MILLION == ZERO, input, MILLION_STRING) + convert(input % MILLION);
        }

        throw new Exception(INVALID);
    }

    private static String getUnit(Predicate<Integer> value, int input, String unit) {
        String result;
        if (unit == null) {
            result = value.test(input) ? EMPTY : SPACE;
        } else {
            result = SPACE + unit;
            if (HUNDRED_STRING.equals(unit)) {
                result += value.test(input) ? EMPTY : AND;
            } else {
                result += value.test(input) ? EMPTY : SPACE;
            }
        }
        return result;
    }

}
