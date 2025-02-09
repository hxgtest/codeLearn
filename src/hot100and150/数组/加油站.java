package hot100and150.数组;

/**
 * @author hxg
 * @description: 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * @date 2025/2/9 10:30
 */
public class 加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, n = gas.length;
        while (start < n) {
            int gasSurplus = 0;
            boolean end = true;
            // 遍历 n 个加油站，确保走完一圈
            for (int count = 0; count < n; count++) {
                int i = (start + count) % n; // 当前检查的加油站索引
                gasSurplus += gas[i] - cost[i];
                if (gasSurplus < 0) {
                    // 如果从 start 出发无法到达 i+1，则下一次尝试起点为 i+1
                    start = start + count + 1; // 直接跳转到 i+1，无需重复检查
                    end = false;
                    break;
                }
            }
            if (end) {
                return start;
            }
        }
        return -1;
    }
}
