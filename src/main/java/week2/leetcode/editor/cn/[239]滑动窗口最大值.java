package week2.leetcode.editor.cn;

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 889 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 1. 边界检查
        // 0 < k < nums.length
        // 2. 记录第一个滑动窗口的最大值
        // 3. 保留最大值

//        1.
        if (k <= 0 || k > nums.length) {
            return new int[]{};
        }

//        2.
//        3.
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            result[i] = max;
        }
        return result;

//        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
//        int k = 3;
//        System.out.println(new Solution().maxSlidingWindow(nums, k));
//    }
//        if (nums.length == 0) return new int[0];
//        int[] result = new int[nums.length - k + 1];
//        int left = 0;
//        int right = left + k - 1;
//        int index = 0;
//        while (right < nums.length) {
//            insert(nums, result, left++, right++, index++);
//        }
//        return result;
//    }
//
//    public void insert(int[] nums, int[] result, int left, int right, int index) {
//        result[index] = Integer.MIN_VALUE;
//        for (int i = left; i <= right; i++) {
//            if (nums[i] > result[index])
//                result[index] = nums[i];
//        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
