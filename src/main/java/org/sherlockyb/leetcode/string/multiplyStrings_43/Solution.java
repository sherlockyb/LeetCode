package org.sherlockyb.leetcode.string.multiplyStrings_43;

/**
 * @author biyang
 */
class Solution {
    public String multiply(String num1, String num2) {
        String zeroStr = "0";

        if (zeroStr.equals(num1) || zeroStr.equals(num2)) {
            return zeroStr;
        }

        StringBuilder result = new StringBuilder(num1.length() + num2.length());
        int sumStart = 0;
        StringBuilder oneRow = new StringBuilder(num1.length());
        for (int i = num2.length()-1; i >= 0; i--, sumStart++) {
            int add2 = char2int(num2.charAt(i));
            oneRow.delete(0, oneRow.length());

            int carry = 0;
            for (int j = num1.length()-1; j >= 0; j--) {
                int add1 = char2int(num1.charAt(j));
                int tempProduct = add1 * add2 + carry;
                carry = tempProduct / 10;

                oneRow.append(int2char(tempProduct % 10));
            }
            if (carry > 0) {
                oneRow.append(int2char(carry));
            }

            carry = 0;
            int sumIndex = 0;
            for (int j = 0; j < oneRow.length(); j++) {
                sumIndex = sumStart + j;

                int sum = char2int(oneRow.charAt(j)) + carry;
                if (sumIndex >= result.length()) {
                    // 先填一个默认的占位
                    result.append('0');
                }

                sum += char2int(result.charAt(sumIndex));
                carry = sum / 10;
                result.setCharAt(sumIndex, int2char(sum % 10));
            }

            while (carry > 0) {
                sumIndex++;

                if (sumIndex >= result.length()) {
                    result.append(int2char(carry));
                    break;
                } else {
                    int sum = char2int(result.charAt(sumIndex)) + carry;
                    carry = sum / 10;

                    result.setCharAt(sumIndex, int2char(sum % 10));
                }
            }
        }

        StringBuilder finalResult = new StringBuilder(result.length());
        for (int i = result.length()-1; i >= 0; i--) {
            finalResult.append(result.charAt(i));
        }

        return finalResult.toString();
    }

    private int char2int(char ch) {
        return ch - '0';
    }
    private char int2char(int integer) {
        return (char) (integer + '0');
    }
}
