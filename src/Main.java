import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l1 = sc.nextInt();
        int r1 = sc.nextInt();
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();

        int j_min = Math.max(l2, 1);
        int j_max = Math.min(r2, r1);

        if (j_min > j_max) {
            System.out.println(0);
            return;
        }

        long sumR = computeSum(r1, j_min, j_max);
        long sumL = computeSum(l1 - 1, j_min, j_max);
        long result = sumR - sumL;
        System.out.println(result);
    }

    // 计算 sum_{j=a}^b floor(m / j)
    private static long computeSum(int m, int a, int b) {
        if (a > b) return 0;
        long sum = 0;
        int current = a;
        while (current <= b) {
            if (m < current) break;
            int q = m / current;
            int next = m / q + 1;
            next = Math.min(next, b + 1);
            sum += (long) q * (next - current);
            current = next;
        }
        return sum;
    }
}