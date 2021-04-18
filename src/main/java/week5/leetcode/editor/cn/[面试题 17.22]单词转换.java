//给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。 
//
// 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//["hit","hot","dot","lot","log","cog"]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 深度优先搜索 广度优先搜索 数组 字符串 
// 👍 37 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> map;
    String ew, bw;
    List<String> result = new ArrayList<>();
    List<String> fake = new ArrayList<>();
    boolean[] flag;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        map = wordList;
        ew = endWord;
        bw = beginWord;
        flag = new boolean[wordList.size()];
        dfs(beginWord);
        return result;

    }

    public boolean dfs(String temp) {
        List<String> neighbhood = near(temp);
        if (!neighbhood.isEmpty()) {
            for (String tt : neighbhood) {
                fake.add(tt);
                if (tt.equals(ew)) {
                    result.add(bw);
                    for (String str : fake) {
                        result.add(str);
                    }
                    return true;
                }
                if (dfs(tt)) {
                    return true;
                } else
                    fake.remove(fake.size() - 1);
            }
        } else {
            return false;
        }
        return false;

    }

    public List<String> near(String str) {
        List<String> res = new ArrayList<>();
        int len1 = str.length();
        for (int j = 0; j < map.size(); j++) {
            String tt = map.get(j);
            if (tt.length() != len1 || flag[j])
                continue;
            int differ = 0;
            for (int i = 0; i < len1; i++) {
                if (str.charAt(i) != tt.charAt(i))
                    differ++;
                if (differ == 2)
                    break;
            }
            if (differ == 1) {
                flag[j] = true;
                res.add(tt);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
