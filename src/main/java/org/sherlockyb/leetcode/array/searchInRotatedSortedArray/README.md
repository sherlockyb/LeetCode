### 33. Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]`).

You are given a target value to search. If found in the array return its index, otherwise return `-1`.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of *O*(log *n*).

**Example 1:**

```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

**Example 2:**

```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

#### 思路（[代码](Solution.java)）

在列表中查找指定元素，要确保*O*(log *n*)的时间复杂度，首先想到的就是在有序表中进行二分查找。

题中，原有序表经过rotated变为两个有序子表，如果能定位两个有序子表的交界处，直接分别在两个子表中二分查找就ok了。那么问题的关键就转变为如何找到这个扭转点。

扭转点的特征就是前面元素比后面元素大，比如示例中列表的扭转点为`<7,0>`。

最直观的做法，就是从前往后相邻两两元素进行比较，但这样光定位扭转点就需要*O*(*n*)的开销，不可取。仔细观察下，会发现扭转点左边的子列表元素都大于右边的子列表元素，如果说一个子列表包含扭转点，那么列表的首部元素肯定是大于尾部元素，否则扭转点就不在该子列表中。

利用这点，我们就可以采用二分的方式，定位扭转点所在位置：从中间将列表分为两半，根据上述规则，判断扭转点是在左边一半的子列表还是右边一半的子列表，确定所在子列表后，再将当前子列表二分，以此类推，最终会收敛到唯一的一对数`<a,b>`，通过判断	`a`、`b`的大小就能判断扭转点存在与否以及其位置。

