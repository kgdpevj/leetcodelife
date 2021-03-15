//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 462 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 先排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int num1Len = nums1.length, num2Len = nums2.length;
        int[] result = new int[Math.min(num1Len, num2Len)];
        int indexRes = 0, indexNum1 = 0, indexNum2 = 0;
        while (indexNum1 < num1Len && indexNum2 < num2Len) {
            if (nums1[indexNum1] < nums2[indexNum2]) {
                indexNum1++;
            } else if (nums1[indexNum1] > nums2[indexNum2]) {
                indexNum2++;
            } else {
                result[indexRes++] = nums1[indexNum1];
                indexNum1++;
                indexNum2++;
            }
        }

        // 截取不为空的单元
        return Arrays.copyOfRange(result, 0, indexRes);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
