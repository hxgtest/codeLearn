import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 测试 dailyTemperatures 方法
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(temperatures);

        // 输出结果
        System.out.print("Result: ");
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return ans;
    }
}