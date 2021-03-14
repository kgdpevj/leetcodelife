//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 356 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) {
            System.out.println("length not equal.");
            return false;
        }
        int[] charCount = new int[26];

        int len = Math.min(s.length(), t.length());
        for (int i = 0; i < len; i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            charCount[t.charAt(i) - 'a']--;
            if (charCount[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
//        for (int i = 0; i < charCount.length; i++) {
//            if (charCount[i] != 0) {
//                return false;
//            }
//        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
