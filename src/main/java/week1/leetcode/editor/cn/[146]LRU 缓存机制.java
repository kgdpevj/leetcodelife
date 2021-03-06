package week1.leetcode.editor.cn.week1;//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
// 
// 
// 实现 leetcode.editor.cn.week1.LRUCache 类：
//
// 
// leetcode.editor.cn.week1.LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["leetcode.editor.cn.week1.LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//leetcode.editor.cn.week1.LRUCache lRUCache = new leetcode.editor.cn.week1.LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1229 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

class Node {
    public int key, value;
    public Node prev, next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleLinkList {
    public Node head, tail;
    public int size;

    public DoubleLinkList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFirst(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleLinkList doubleLinkList;
    //容量
    private final int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        doubleLinkList = new DoubleLinkList();
    }

    public int get(int key) {
        if (map.keySet().contains(key)) {
            int val = map.get(key).value;
            doubleLinkList.removeNode(map.get(key));
            doubleLinkList.addFirst(map.get(key));
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        doubleLinkList.addFirst(node);
        doubleLinkList.size++;
        if (map.keySet().contains(key)) {
            Node old = map.get(key);
            doubleLinkList.removeNode(old);
            doubleLinkList.size--;
        } else {
            if (doubleLinkList.size > cap) {
                Node last = doubleLinkList.tail.prev;
                doubleLinkList.removeNode(last);
                map.remove(last.key);
            }
        }
        map.put(key, node);
    }
}

/**
 * Your leetcode.editor.cn.week1.LRUCache object will be instantiated and called as such:
 * leetcode.editor.cn.week1.LRUCache obj = new leetcode.editor.cn.week1.LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
