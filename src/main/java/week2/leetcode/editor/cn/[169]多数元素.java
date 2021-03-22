//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 位运算 数组 分治算法 
// 👍 921 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
// 统计个数
//        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        long limit = nums.length >> 1;
//        for (Map.Entry<Integer, Long> entry : map.entrySet())
//            if (entry.getValue() > limit)
//                return entry.getKey();
//        return -1;

//        先排序，再取中间位置的值
//        多数元素个数是大于2/n的
//        nums = Arrays.stream(nums).sorted().toArray();
//        return nums[nums.length >>1];

//        摩尔投票
        int voteNum = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == voteNum) {
                count++;
            } else if (--count == 0) {
                voteNum = nums[i];
                count = 1;
            }
            System.out.println(count);
        }
        return voteNum;

//        位运算 不成功
//        int major = 0;
//        int length = nums.length;
//        //在java中int类型是32位，我们遍历每一位
//        for (int i = 0, mask = 1; i < 32; i++, mask <<= 1) {
//            //bitCounts表示所有数字在当前位置1的个数。比如当i=0
//            //的时候，我们可以认为他表示的是所有数字在二进制位
//            //中最右边1的总数。
//            int bitCounts = 0;
//            for (int j = 0; j < length; j++) {
//                //判断数字nums[j]的第i（i从0开始）个位置是否为1，
//                //如果是1，bitCounts就加1
//                if ((nums[j] & mask) == 1)
//                    bitCounts++;
//                //如果bitCounts大于数组的一半，那么这个众数在
//                //这个位置肯定是1，然后通过 major |= mask运算
//                //把这个位置变为1，后面不需要再判断了，直接终止
//                //内层循环
//                if (bitCounts > length >>1) {
//                    major |= mask;
//                    break;
//                }
//            }
//        }
//        return major;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
