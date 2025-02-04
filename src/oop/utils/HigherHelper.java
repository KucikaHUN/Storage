/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import oop.types.PropertyType;

/**
 *
 * @author kucik
 */
class HigherHelper {

    private static final Map<PropertyType, Function<UtilHigherHelper, Boolean>> upperHelper;

    static {
        upperHelper = fillUpperHelper();

    }

    private HigherHelper() {
    }

    public static boolean isActualUpper(PropertyType type, UtilHigherHelper helper) {
        return upperHelper.get(type).apply(helper);
    }

    private static Map<PropertyType, Function<UtilHigherHelper, Boolean>> fillUpperHelper() {
        Map<PropertyType, Function<UtilHigherHelper, Boolean>> result = new HashMap<>();

        result.put(PropertyType.ARTICLE_NUMBER, (util) -> actualHigherString(util));
        result.put(PropertyType.NAME, (util) -> actualHigherString(util));
        result.put(PropertyType.BRAND, (util) -> actualHigherString(util));
        result.put(PropertyType.FAMILY, (util) -> actualHigherString(util));
        result.put(PropertyType.NETTO_PRICE, (util) -> actualHigherInteger(util));
        result.put(PropertyType.TAX_ID, (util) -> actualHigherInteger(util));
        result.put(PropertyType.QUANTITY, (util) -> actualHigherInteger(util));
        result.put(PropertyType.CRITICAL_QUANTITY, (util) -> actualHigherInteger(util));
        result.put(PropertyType.AMOUNT_UNITS, (util) -> actualHigherString(util));
        result.put(PropertyType.EXPIRATION_DATE, (util) -> actualHigherLocalDate(util));
        result.put(PropertyType.PRODUCTION_DATE, (util) -> actualHigherLocalDate(util));
        result.put(PropertyType.WARANTY_PERIOD, (util) -> actualHigherInteger(util));
        result.put(PropertyType.GROSS_WEIGHT, (util) -> actualHigherBigDecimal(util));
        result.put(PropertyType.TAX_KEY, (util) -> actualHigherInteger(util));

        return result;
    }

    static class UtilHigherHelper {

        String actual;
        String next;

        public UtilHigherHelper(String actual, String next) {
            this.actual = actual;
            this.next = next;
        }
    }

    private static boolean actualHigherString(UtilHigherHelper values) {
        String actual = values.actual;
        String next = values.next;
        boolean result = false;
        int actualValue;
        int nextValue;
        int maxStep = calculateMaxStep(actual, next);
        for (int i = 0; i < maxStep; i++) {
            actualValue = actual.charAt(i);
            nextValue = next.charAt(i);
            actualValue = decreaseValueIfNeed(actualValue);
            nextValue = decreaseValueIfNeed(nextValue);
            if (actualValue > nextValue) {
                result = true;
                i = actual.length();
            } else if (actualValue < nextValue) {
                i = actual.length();
                result = false;
            }
            if (i >= maxStep - 1 && actualValue == nextValue && actual.length() > next.length()) {
                result = true;
            }
        }
        if (maxStep == 0 && actual.length() > next.length()) {
            result = true;
        }
        return result;
    }

    private static boolean actualHigherInteger(UtilHigherHelper values) {
        String actual = values.actual;
        String next = values.next;
        int actualInteger = Integer.parseInt(actual);
        int nextInteger = Integer.parseInt(next);
        return actualInteger > nextInteger;
    }

    private static boolean actualHigherBigDecimal(UtilHigherHelper values) {
        String actual = values.actual;
        String next = values.next;
        double actualDouble = Double.parseDouble(actual);
        double nextDouble = Double.parseDouble(next);
        BigDecimal actualBigD = BigDecimal.valueOf(actualDouble);
        BigDecimal nextBigD = BigDecimal.valueOf(nextDouble);
        return actualBigD.doubleValue() > nextBigD.doubleValue();
    }

    private static boolean actualHigherLocalDate(UtilHigherHelper values) {
        String actual = values.actual;
        String next = values.next;
        LocalDate actualDate = Util.textToDate(actual);
        LocalDate nextDate = Util.textToDate(next);
        return actualDate.isBefore(nextDate);
    }

    private static int decreaseValueIfNeed(int value) {
        if (value >= 97) {
            value -= 32;
        }
        return value;
    }

    private static int calculateMaxStep(String actual, String next) {
        int result = actual.length();
        if (next.length() < result) {
            result = next.length();
        }
        return result;
    }
}
