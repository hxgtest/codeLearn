package hot100second.栈;

import java.util.Stack;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/30 16:02
 */
public class MinStack {
    public Stack<Integer> stack1,stack2;
    public MinStack() {
        stack1=new Stack<>();
        stack2=new Stack<>();
        stack2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack2.push(Math.min(val,stack2.peek()));
        stack1.push(val);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
