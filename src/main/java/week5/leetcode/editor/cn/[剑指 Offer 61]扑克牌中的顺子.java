//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 120 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        //对子
        int[] bucket = new int[14];
        int max = -1;
        int min = 14;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            //有非0的对子,直接false
            if (bucket[nums[i]] == 1) return false;
            bucket[nums[i]]++;
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        return max - min <= 4;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
