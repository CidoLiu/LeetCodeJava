package solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dongjin
 * @id 225
 * @date 2020/11/9 10:04
 */
public class MyStack {

    Queue<Integer> in;
    Queue<Integer> out;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        in.offer(x);
        while (!out.isEmpty()) {
            in.offer(out.poll());
        }
        while (!in.isEmpty()) {
            out.offer(in.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return out.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return out.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return out.isEmpty();
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(6);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }
}
