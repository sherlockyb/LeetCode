package org.sherlockyb.leetcode.math.powXN_50;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author biyang
 */
public class Solution2 {
    public double myPow(double x, int n) {
        final double result;
        if (n >= 0) {
            result = getMultiResult(x, n);
        } else {
            // 处理特殊case：当n = -2^32时，-n 会溢出，所以 n 先要拆成 (n+1) + (-1)，然后再转为正数
            if (n == Integer.MIN_VALUE) {
                result = 1.0 / (x * getMultiResult(x, -(n+1)));
            } else {
                result = 1.0 / getMultiResult(x, -n);
            }
        }

        final BigDecimal bd = new BigDecimal(result).setScale(5, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

    private double getMultiResult(final double x, final int n) {
        if (n == 0) {
            return 1;       // 根据test case，输入x = 0, n = 0 时返回1，因而忽略 x = 0 时非法值的处理
        }

        if (n % 2 == 0) {
            final double half = getMultiResult(x, n/2);
            return half * half;
        } else {
            final double half = getMultiResult(x, (n-1) / 2);
            return x * half * half;
        }
    }
}
