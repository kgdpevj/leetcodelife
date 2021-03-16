package week1.leetcode.editor.cn;//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 643 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 末位加1
 * 要处理的问题：进位
 *  1. 向前进位---->从最后一位开始处理
 *      本位模10取余，前1位加1
 *  2. 循环检查每一位，重复步骤1
 *  3. 最高位特殊处理
 *      1. 无进位，直接返回
 *      2. 有进位，加一个最高位，最高位重复步骤1
 *
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len - 1] += 1;
        for (int i = len - 1; i > 0; i--) {
            if (digits[i] > 9) {
                digits[i] %= 10;
                digits[i - 1] += 1;
            }
        }
        if (digits[0] < 10) {
            return digits;
        } else {
            int[] digitstmp = new int[len + 1];
            System.arraycopy(digits, 0, digitstmp, 1, len);
            digitstmp[1] %= 10;
            digitstmp[0] = 1;
            return digitstmp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
