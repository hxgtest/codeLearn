import java.util.*;
import java.io.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        scanner.close();

        // 寻找第一个错误的位置
        int kError = -1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int k = 0; k < n; k++) {
            int element = b[k];
            if (element > 0) {
                stack.push(element);
            } else {
                int value = -element;
                if (stack.isEmpty()) {
                    kError = k;
                    break;
                }
                if (stack.peek() != value) {
                    kError = k;
                    break;
                }
                stack.pop();
            }
        }
        // 处理所有元素处理完但栈不为空的情况
        if (kError == -1 && !stack.isEmpty()) {
            kError = n - 1;
        }

        // 生成候选交换的位置
        List<int[]> candidates = new ArrayList<>();
        if (kError > 0) {
            candidates.add(new int[]{kError - 1, kError});
        }
        if (kError < n - 1) {
            candidates.add(new int[]{kError, kError + 1});
        }

        // 检查每个候选交换是否合法
        for (int[] candidate : candidates) {
            int u = candidate[0];
            int v = candidate[1];
            if (isValid(b, u, v)) {
                System.out.println((u + 1) + " " + (v + 1));
                return;
            }
        }

        // 如果未找到（题目保证存在解，此处为兜底）
        System.out.println((n - 1) + " " + n);
    }

    private static boolean isValid(int[] b, int swapI, int swapJ) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int k = 0; k < b.length; k++) {
            int element = b[k];
            if (k == swapI) {
                element = b[swapJ];
            } else if (k == swapJ) {
                element = b[swapI];
            }
            if (element > 0) {
                stack.push(element);
            } else {
                int value = -element;
                if (stack.isEmpty() || stack.peek() != value) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}