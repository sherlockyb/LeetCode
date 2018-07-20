### 6. ZigZag Conversion

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

```
P   A   H   N
A P L S I I G
Y   I   R

```

And then read line by line: `"PAHNAPLSIIGYIR"`

Write the code that will take a string and make this conversion given a number of rows:

```
string convert(string text, int nRows);
```

`convert("PAYPALISHIRING", 3)` should return `"PAHNAPLSIIGYIR"`.

#### 思路1（[代码](https://github.com/sherlockyb/LeetCode/blob/master/src/main/java/org/sherlockyb/leetcode/string/zigZagConversion/Solution.java)）

  直接从最终排列的结构中找规律：关键点——每一排中相邻两个字符在原字符串中对应下标的间隔。由于排列后，第1~nRows排的第一个字符直接就可以确定为原字符串前nRows个字符，那么得到当排的相邻字符下标间隔后，其后续字符都可根据下标依次取得，然后依次从第1~nRows排按下标取字符即可得最终结果。

  细节：将两个相邻字符的间隔拆分成两部分——竖线和斜线。比如对于示例中P和A的间隔，则由P到Y的间隔（竖线部分）+Y到A的间隔（斜线部分）组成。另外，同一排中相邻两字符的间隔有两种，step1和step2，对称且交替变换，具体见代码。

#### 思路2（[代码](https://github.com/sherlock-y/LeetCode/blob/master/src/main/java/org/sherlocky/leetcode/string/zigZagConversion/SolutionB.java)）

  沿着折线的绘制轨迹依次扫描原字符串，会发现字符所处的行从0上升到nRows-1，然后又从nRows-1下降到0，如此周而复始直到字符序列尾部。由此，预先定义大小为nRows的StringBuilder数组，按以上规律依次扫描原字符串，将字符放置对应行的StringBuilder，最后将数组中的若干字符串拼接即可。