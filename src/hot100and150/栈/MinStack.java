package hot100and150.栈;
/*设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

实现 MinStack 类:

MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。*/

import java.util.Stack;

public class MinStack {
    public Stack<Integer> queue1,queue2;
    public MinStack() {
        queue1=new Stack<>();
        queue2=new Stack<>();
        queue2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        queue2.push(Math.min(val,queue2.peek()));
        queue1.push(val);
    }

    public void pop() {
        queue1.pop();
        queue2.pop();
    }

    public int top() {
        return queue1.peek();
    }

    public int getMin() {
        return queue2.peek();
    }
}
