package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @id 155
 * @author dongjin
 * @date 2020/11/7 19:27
 */
public class MinStack {

    private List<Integer> list;
    private List<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        this.list = new LinkedList<>();
        this.min = new LinkedList<>();
    }

    public void push(int x) {
        this.list.add(x);
        if (this.min.isEmpty()) {
            min.add(x);
        } else {
            if (min.get(min.size()-1) < x) {
                min.add(min.get(min.size()-1));
            } else {
                min.add(x);
            }
        }
    }

    public void pop() {
        this.min.remove(min.size()-1);
        this.list.remove(list.size()-1);
    }

    public int top() {
        return this.list.get(list.size()-1);
    }

    public int getMin() {
        return this.min.get(min.size()-1);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
