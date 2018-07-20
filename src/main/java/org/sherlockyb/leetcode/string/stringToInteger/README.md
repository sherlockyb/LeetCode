### 8. String to Integer (atoi)

Implement atoi to convert a string to an integer.

**Hint:** Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

**Notes:** It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

#### 思路（[代码](https://github.com/sherlockyb/LeetCode/blob/master/src/main/java/org/sherlockyb/leetcode/string/stringToInteger/Solution.java)）

  字符串转整数，常规题。根据字符与'0'的ASCII码值的差得到对应数字的值，然后按位累加即可。

  细节：1. 非法字符的处理；2. 加号和减号的处理； 3. 溢出的处理（上溢和下溢）

  吐槽：该题对于非法字符的处理方式**较隐晦，且不合理**。经过多次TestCase才试探出其处理逻辑：忽略开头的空白符，对于第一个非空白符，要么是“+”，要么是“-”，要么是数字。对于后续字符，依次取数字，遇到第一个非数字字符或到达字符串末尾，即结束扫描，将前面得到的结果返回。PS：对于这种"  -01033efegeageaa fewfaa1131313"，应该直接抛出NumberFormatException才对，而不应该是-1033。没办法，为了AC，只能按题目意思照做罗。