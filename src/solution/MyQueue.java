package solution;

import java.util.Stack;

/**
 * @id 232
 * @author dongjin
 * @date 2020/11/9 15:03
 */
public class MyQueue {

    private Stack<Integer> temp;
    private Stack<Integer> out;

    /** Initialize your data structure here. */
    public MyQueue() {
        temp = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!out.empty()) {
            temp.push(out.pop());
        }
        out.push(x);
        while (!temp.empty()) {
            out.push(temp.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return out.empty();
    }

    public static void main(String[] args) {
        MyQueue temple = new MyQueue();
        temple.push(1);
        temple.push(2);
        System.out.println(temple.peek());
    }
}
