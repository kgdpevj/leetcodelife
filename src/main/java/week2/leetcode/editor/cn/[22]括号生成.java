//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1631 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        _generate(0, 0, n, "");
        return result;
    }

    private void _generate(int left, int right, int n, String s) {
//        1. recursion terminator
        if (left == n && right == n) {
            result.add(s);
            return;
        }

//        2. process logic in current level

//        3. drill down
        if (left < n) {
            _generate(left + 1, right, n, s + "(");
        }
        if (left > right) {
            _generate(left, right + 1, n, s + ")");
        }

//        4. revert the current level status if needed
    }
}
//leetcode submit region end(Prohibit modification and deletion)
