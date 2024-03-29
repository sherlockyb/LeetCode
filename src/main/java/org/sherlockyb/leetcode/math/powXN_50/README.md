### 50. Pow(x, n)

Implement [pow(x, n)](http://www.cplusplus.com/reference/valarray/pow/), which calculates `x` raised to the power `n` (i.e., `x^n`).

 

**Example 1:**

```
Input: x = 2.00000, n = 10
Output: 1024.00000
```

**Example 2:**

```
Input: x = 2.10000, n = 3
Output: 9.26100
```

**Example 3:**

```
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2^2 = 1/2^2 = 1/4 = 0.25
```

 

**Constraints:**

- `-100.0 < x < 100.0`
- `-2^31 <= n <= 2^31-1`
- `-104 <= x^n <= 104`

#### 思路

此题 `n` 为整数，则不用考虑为小数时开根号的问题，相对容易。

第一版思路。根据 `n` 的取值分为三种情况，大于 0 时， `x^n` 直接转换成 `n` 个 `x` 相乘即可；等于 0 时，若 `x` 非 0，则为 1，若 `x` 为 0，则为NAN（此种情况不用考虑，因为 `x^n` 的取值在有效范围）；小于 0 时，可转换成 `1/x^(-n)`计算，分母的计算可按照第一种情况处理。见[代码1](Solution.java)，虽然逻辑正确，但可惜 `Time Limit Exceeded` 了，也是预料之中，毕竟 `n` 最大能达到 `2^31-1`，也就是说即便 `x` 是 1，也要做这么多次乘法，肯定疯了。

第二版思路，为了减少乘法次数，可对 `n` 做二分处理：当 `n` 为偶数时，直接 `x^n = x^(n/2) * x^(n/2)` 递推计算；当 `n` 为奇数时，`x^n = x * x^((n-1)/2) * x^((n-2)/2)`。基于递推公式，进行递归或动态规划处理。见[代码2](Solution2.java)，accepted 了。

对于第二版思路，要注意两个地方，

> 1. 当 n = -2^31 时，不能直接通过 `-n` 转为正数的边界 case，整数溢出问题
> 2. 采用递归处理时，千万别通过 `getMultiResult(x, n/2) * getMultiResult(x, n/2)` 的方式来计算，因为调用两次子函数，会导致两条重复的递归链路，大量重复计算，跟第一版思路的性能没差别了。记得先把 `getMultiResult(x, n/2)` 的**结果暂存起来，然后计算结果的二次方，这样才能利用已有子问题的解而避免重复计算**。