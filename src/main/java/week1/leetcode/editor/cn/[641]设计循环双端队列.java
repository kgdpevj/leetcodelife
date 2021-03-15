package week1.leetcode.editor.cn;

//设计实现双端队列。
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列 
// 👍 76 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


class MyCircularDeque {
    int head;
    int tail;
    int[] value;
    int length;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.value = new int[k];
        this.head = -1;
        this.tail = -1;
        this.length = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        // 队列满了，插入失败
        if (this.length == this.value.length) {
            return false;
        }
        if (head == -1) {
            head = tail = 0;
        } else {
            head = (head - 1 + this.value.length) % this.value.length;
        }
        this.value[head] = value;
        this.length++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        // 队列满了，插入失败
        if (this.length == this.value.length) {
            return false;
        }
        if (tail == -1) {
            tail = head = 0;
        } else {
            tail = (tail + 1) % this.value.length;
        }
        this.value[tail] = value;
        this.length++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (this.length == 0) {
            return false;
        }
        head = (head + 1) % this.value.length;
        this.length--;
        if (this.length == 0) {
            head = -1;
            tail = -1;
        }
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (this.length == 0) {
            return false;
        }
        tail = (tail - 1 + this.value.length) % this.value.length;
        this.length--;
        if (this.length == 0) {
            head = -1;
            tail = -1;
        }
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (!isEmpty()) {
            return this.value[head];
        } else {
            return -1;
        }
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (!isEmpty()) {
            return this.value[tail];
        } else {
            return -1;
        }
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return this.length == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return this.length == value.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)
