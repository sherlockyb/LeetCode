package org.sherlocky.leetcode.math.integerToRoman;

/**
 * Created by yangbing on 2017/4/10.
 */
public class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        if (num > 3999) {
            // 超出了该解法的处理范围，直接异常
            throw new RuntimeException("exceed the acceptable range: " + num);
        }
        int mNum = num / 1000;
        if (mNum > 0) {
            for (int i = 0; i < mNum; i++) {
                result.append("M");
            }
            num = num % 1000;
        }
        num = doProcess(result, num, 100, "C", "M", "D");
        num = doProcess(result, num, 10, "X", "C", "L");
        doProcess(result, num, 1, "I", "X", "V");

        return result.toString();
    }

    private int doProcess(
            StringBuilder result,               //结果串
            int curNum,                         //当前数值
            int magnitude,                      //当前量级：比如10
            String magnitudeLiteral,            //当前量级对应的字面，如X（对应上面的10）
            String doubleMagnitudeLiteral,      //当前量级乘以10后对应的字面，如C（100）
            String dHalfMagnitudeLiteral) {     //当前量级乘以10后的一半对应字面，如L（50）
        int shed = 9*magnitude;
        if (curNum >= shed) {
            result.append(magnitudeLiteral + doubleMagnitudeLiteral);
            curNum -= shed;
        }
        int nX = curNum / magnitude;
        if (nX > 0) {
            switch (nX) {
                case 1:
                case 2:
                case 3:
                    for (int i = 0; i < nX; i++) {
                        result.append(magnitudeLiteral);
                    }
                    break;
                case 4:
                    result.append(magnitudeLiteral + dHalfMagnitudeLiteral); break;
                case 5:
                case 6:
                case 7:
                case 8:
                    result.append(dHalfMagnitudeLiteral);
                    for (int i = 0; i <= nX - 6; i++) {
                        result.append(magnitudeLiteral);
                    }
            }
            curNum = curNum % magnitude;
        }
        return curNum;
    }
}
