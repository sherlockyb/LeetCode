package org.sherlockyb.leetcode.math.divideTwoIntegers_29;

/**
 * Created by yangbing on 2018/10/31.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        boolean negative = false;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            negative = true;
        }
        int dendBit = 0;
        if (dividend < 0) {
            // 直接0-dividend，对于最小负数会溢出，故先加1再置反
            dividend = 0 - (dividend + 1);
            dendBit = 1;
        }
        int dsorBit = 0;
        if (divisor < 0) {
            divisor = 0 - (divisor + 1);
            dsorBit = 1;
        }
        int n = 0;
        // dendBit只能在第一次条件判断和减法时生效，后续的条件判断和减法都不能用，因为它是减数的偏差，只会产生一次，
        // 而dsorBit则是被减数的偏差，必须每次都生效，二者要区别对待
        if (dividend - dsorBit >= divisor - dendBit) {
            dividend = dividend  - divisor - dsorBit;
            dividend += dendBit;
            n--;
        }
        if (divisor < 500000000) {
            divisor += dsorBit;
            int doubleDivisor = divisor + divisor;
            int doubleCount = 2;
            while (dividend >= doubleDivisor && doubleDivisor < 1000000000) {
                dividend -= doubleDivisor;
                if (n < -2147483648 + doubleCount) {
                    return negative ? -2147483648: 2147483647;
                }
                n -= doubleCount;
                doubleDivisor += doubleDivisor;
                doubleCount += doubleCount;
            }
            while (true) {
                doubleDivisor = doubleDivisor >> 1;
                doubleCount = doubleCount >> 1;
                while (dividend >= doubleDivisor) {
                    dividend -= doubleDivisor;
                    if (n < -2147483648 + doubleCount) {
                        return negative ? -2147483648: 2147483647;
                    }
                    n -= doubleCount;
                }
                if (dividend < divisor || doubleCount < 2) {
                    break;
                }
            }

        } else {
            while (dividend - dsorBit >= divisor) {
                dividend = dividend  - divisor - dsorBit;
                n--;
                if (n <= -2147483648) {
                    return negative ? n: 2147483647;
                }
            }
        }
        return negative ? n: (n > -2147483648? -n : -(n+1));
    }
}
