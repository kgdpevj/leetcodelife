package week3.leetcode.editor.cn;//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 118 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
//        Stack<ListNode> stack = new Stack<>();
//        ListNode cur = head;
//        while (cur != null) {
//            stack.push(cur);
//            cur = cur.next;
//        }
//        int size = stack.size();
//        int[] ret = new int[size];
//        for (int i = 0; i < size; i++) {
//            ret[i] = stack.pop().val;
//        }
//        return ret;

        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        int[] ret = new int[size];
        cur = head;
        int i = size - 1;
        while (i >= 0) {
            ret[i--] = cur.val;
            cur = cur.next;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
