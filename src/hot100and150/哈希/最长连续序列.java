package hot100and150.哈希;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hxg
 * @description: 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @date 2025/2/15 11:31
 */
public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int len = 1;
                int curnum = num;
                while (set.contains(curnum + 1)) {
                    len++;
                    curnum++;
                }
                max = Math.max(max, len);
            }

        }
        return max;
    }
}
