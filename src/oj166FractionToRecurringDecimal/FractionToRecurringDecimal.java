package oj166FractionToRecurringDecimal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example 1:
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 *
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 */

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
//        StringBuilder result = new StringBuilder();
//        Map<Long, Integer> map = new HashMap<>();
//        result.append(numerator / denominator);
//        if(numerator % denominator == 0) {
//            return result.toString();
//        }
//        if(numerator != 0) {
//            result.append(".");
//        }
//        long num = Math.abs((long)numerator);
//        long den = Math.abs((long)denominator);
//        map.put(num, result.length());
//        num %= den;
//        while(num > 0) {
//            num *= 10;
//            result.append(num / den);
//            num %= den;
//            if(map.containsKey(num)) {
//                int index = map.get(num);
//                result.insert(index, "(");
//                result.append(")");
//                break;
//            } else {
//                map.put(num, result.length());
//            }
//        }
//        return result.toString();
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

    public static void main(String args[]) {
        FractionToRecurringDecimal fractionToRecurringDecimal = new FractionToRecurringDecimal();
        System.out.println(fractionToRecurringDecimal.fractionToDecimal(22, 7));
    }
}
