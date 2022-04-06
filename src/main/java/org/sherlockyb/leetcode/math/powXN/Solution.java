package org.sherlockyb.leetcode.math.powXN;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author sherlockyb
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return x == 0 ? 0: 1;
        }

        final double result;
        if (n > 0) {
            result = getMultiResult(x, n);
        } else {
            result = 1.0 / getMultiResult(x, -n);
        }

        final BigDecimal bd = new BigDecimal(result).setScale(5, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

    private double getMultiResult(final double x, final int n) {
        double result = 1.0D;
        for (int i = 0; i < n; i++) {
            result *= x;
        }

        return result;
    }
}
