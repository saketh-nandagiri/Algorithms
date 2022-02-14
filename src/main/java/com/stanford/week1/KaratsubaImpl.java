package com.week1;

import java.math.BigInteger;

public class KaratsubaImpl {


    public static void main(String[] args) {
        String int1 = "3141592653589793238462643383279502884197169399375105820974944592";
        String int2 = "2718281828459045235360287471352662497757247093699959574966967627";

        BigInteger productResult = getProductApproach2(new BigInteger(int1), new BigInteger(int2));
        System.out.println(productResult.toString());
    }

    private static BigInteger getProductApproach2(BigInteger number_1, BigInteger number_2) {

        String num1_str = number_1.toString();
        String num2_str = number_2.toString();

        // base case
        if (num1_str.length() == 1 && num2_str.length() == 1)
            return number_1.multiply(number_2);

        int maxLength = Math.max(num1_str.length(), num2_str.length());

        if (!checkPerfectPowerOfTwo(maxLength)){
            int additionalPadding = getPerfectPaddingValue(maxLength);

            if (num1_str.length() == maxLength) {
                num1_str = getPaddedNumberStr(num1_str, additionalPadding);
                num2_str = getPaddedNumberStr(num2_str, num1_str.length() - num2_str.length());
            } else {
                num2_str = getPaddedNumberStr(num2_str, additionalPadding);
                num1_str = getPaddedNumberStr(num1_str, num2_str.length() - num1_str.length());
            }
        } else if (num1_str.length() != num2_str.length()) {
            if (num1_str.length() == maxLength) {
                num2_str = getPaddedNumberStr(num2_str, num1_str.length() - num2_str.length());
            } else {
                num1_str = getPaddedNumberStr(num1_str, num2_str.length() - num1_str.length());
            }
        }

        BigInteger a = new BigInteger(num1_str.substring(0, num1_str.length()/2));
        BigInteger b = new BigInteger(num1_str.substring(num1_str.length()/2));

        BigInteger c =  new BigInteger(num2_str.substring(0, num2_str.length()/2));
        BigInteger d = new BigInteger(num2_str.substring(num2_str.length()/2));

        BigInteger product1 = getProductApproach2(a, c);
        BigInteger product3 = getProductApproach2(b, d);

        BigInteger intermediateValue = getProductApproach2(a.add(b), c.add(d));
        BigInteger product2 = intermediateValue.subtract(product1).subtract(product3);

        BigInteger result = product1.multiply(BigInteger.TEN.pow(num1_str.length())).
                add(product3).
                add(product2.multiply(BigInteger.TEN.pow(num1_str.length()/2)));

        return result;
    }

    private static int getPerfectPaddingValue(int value) {
        for (int i = 2; i < (int) Math.pow(2, 20); i = i * 2) {
            if ( value < i)
                return i - value;
        }
        return -1;
    }

    private static boolean checkPerfectPowerOfTwo(int value) {
        while (value > 1) {
            if (value % 2 == 0) {
                value = value / 2;
                continue;
            }
            return false;
        }
        return true;
    }

    private static String getPaddedNumberStr(String number, int zeros_to_add) {
        if (zeros_to_add <= 0)
            return number;
        String s = "";
        for (int value = 0; value < zeros_to_add; value++)
            s += "0";

        return s.concat(number);
    }

    private static BigInteger getProductApproach1(BigInteger number_1, BigInteger number_2) {
        // base case
        if (number_1.toString().length() == 1 || number_2.toString().length() == 1)
            return number_1.multiply(number_2);

        int pow = Math.min(number_1.toString().length() - 1, number_2.toString().length() - 1);


        BigInteger base = new BigInteger(String.valueOf(BigInteger.TEN.pow(pow)));
        BigInteger a = number_1.divide(base);
        BigInteger b = number_1.mod(base);

        BigInteger c =  number_2.divide(base);
        BigInteger d = number_2.mod(base);

        BigInteger product1 = getProductApproach1(a, c);
        BigInteger product3 = getProductApproach1(b, d);

        BigInteger intermediateValue = getProductApproach1(a.add(b), c.add(d));
        BigInteger product2 = intermediateValue.subtract(product1).subtract(product3);

        BigInteger result = product1.multiply(base.pow(2)).
                add(product3).
                add(product2.multiply(base));

        return result;
    }

}
