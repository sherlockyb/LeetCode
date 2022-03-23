### 48. Rotate Image

You are given an `n x n` 2D `matrix` representing an image, rotate the image by **90** degrees (clockwise).

You have to rotate the image [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm), which means you have to modify the input 2D matrix directly. **DO NOT** allocate another 2D matrix and do the rotation.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg)

```
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
```

**Example 2:**

![img](https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg)

```
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
```

 

**Constraints:**

- `n == matrix.length == matrix[i].length`
- `1 <= n <= 20`
- `-1000 <= matrix[i][j] <= 1000`

#### 思路（[代码](Solution.java)）

只能在原图像上旋转，也就是需要通过交换达到旋转的效果。

2D 图像上下左右对称，以图像中心点的水平线为界，只需要处理上半部分，那么下半部分自动就归位了。

然后对于上半部分，逐个小方块交换到目的位置：比如 example 2 中的第一个方块 5，先将其交换到原 11 的位置，此时 11 被赶出来，需要交换到它的目的地，即原 16 的位置，而对于 16，则需要继续往前走，到达原 15 的位置，而对于 15，则刚好交换到原 5 的位置，一共4次，完成了第一个小方块的旋转；对于其他方块，以此类推。

最后就是交换的规律了：从外到内，依次为边长为 `N, N/2, ..., 1` 个小正方块组成的正方形。对于边长为 `M ` 个小方块的正方形中的某个小方块，顺时针旋转 90 度则意味着该小方块沿着正方形的边顺时针走 `N-1`步，当沿着某条边走到底而还没到目的地时，需要拐弯儿，而拐弯儿的方向则取决于该方块初始所在的边。

整体思路并不难，唯一的难点在于多个细节的处理，例如下面比较重要的几条：

> 利用对称，如何圈出上半部分元素
>
> 对指定元素 `matric[i][j]` 处理时需要知道该元素位于所属正方形的哪个位置，是四角顶点？还是顶点之外的边内节点？通过顶点坐标的规律解决。
>
> 当要对该元素进行挪动时，往上下左右哪个方向走？需要走几步到达所处边终点然后拐弯？需要利用与中心点的相对位置来判断。
>
> N 为偶数还是奇数，中心位置的情况会有所不同。