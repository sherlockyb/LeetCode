### 9. Palindrome Number

Determine whether an integer is a palindrome. Do this without extra space.

#### 思路（[代码](https://github.com/sherlockyb/LeetCode/blob/master/src/main/java/org/sherlockyb/leetcode/math/palindromeNumber/Solution.java)）

  由于不能利用额外存储空间，可利用回文的特征，直接将数字逆序，再判断与原数字是否相等。逆序过程中，如果有溢出，则直接判定不是回文。

  也可以先得到该整数的总位数，这个较容易，假设为N。根据位数就直接能拿到最高位，然后直接与最低位比较，依次类推。