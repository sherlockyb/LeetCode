### 7. Reverse Integer

Reverse digits of an integer.

**Example1:** x = 123, return 321
**Example2:** x = -123, return -321

**Note:**
The input is assumed to be a 32-bit signed integer. Your function should **return 0 when the reversed integer overflows**.

#### 思路1（[代码](https://github.com/sherlockyb/LeetCode/blob/master/src/main/java/org/sherlockyb/leetcode/math/reverseInteger/Solution.java)）

  将数字逆序，问题本身比较常规，但**溢出问题**很容易被忽略：逆序后的数字可能超出取值范围。一开始想的是用Long类型保存结果，但如果问题换成Long类型的输入，这种做法就不可取了。故先将输入转为字符串，然后校验字符串是否在取值范围内，如果是就转为数字，否则返回0.

  细节：比较逆序结果在字符串形式上与Integer最大/小值的大小时，要注意位对齐，即高位补0字符！因为字符串比较是字典序，若不对齐，就会出现"321" > "2147483647"的情况。

#### 思路2

  上述思路还是停留在先想方设法保存逆序结果（如更大范围的Long类型，字符串等），然后再通过比较大小看其是否在取值范围内来判断溢出。其实对于溢出的判断还有更巧妙的思路，如对于加法，可看标志位；对于乘法，可看除回来的数是否跟原来的数字不一样，具体可参考[代码](http://coolshell.cn/articles/11466.html)，这里我就不重复实现了。