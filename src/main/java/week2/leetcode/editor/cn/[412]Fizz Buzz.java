//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// 👍 90 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fizzBuzz(int n) {
        // List res = new ArrayList();
        // int limit=n+1;
        // for (int i = 1; i < limit; i++) {
        //     int m3 = i%3;
        //     int m5 = i%5;
        //     if(m3==0&& m5==0){
        //         res.add("FizzBuzz");
        //     }
        //     else if (i % 3 == 0) {
        //         res.add("Fizz");
        //     } else if (i % 5 == 0) {
        //         res.add("Buzz");
        //     } else {
        //         res.add(String.valueOf(i));
        //     }
        // }
        // return res;

        // return IntStream.range(1, n + 1).mapToObj(i -> {
        //     if (i % 3 == 0 && i % 5 == 0) return "FizzBuzz";
        //     if (i % 3 == 0) return "Fizz";
        //     if (i % 5 == 0) return "Buzz";
        //     return String.valueOf(i);
        // }).collect(Collectors.toList());

        return  new java.util.AbstractList<String>() {
            @Override
            public String get(int i) {
                i++;
                switch ((i % 3 == 0 ? 1 : 0) + (i % 5 == 0 ? 2 : 0)) {
                    case 0:
                        return String.valueOf(i);
                    case 1:
                        return "Fizz";
                    case 2:
                        return "Buzz";
                    case 3:
                        return "FizzBuzz";
                    default:
                        return "";
                }
            }
            @Override
            public int size() {
                return n;
            }
        };
    }
}
//leetcode submit region end(Prohibit modification and deletion)
