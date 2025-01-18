package hot100and150.图论;

import java.util.*;

//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
//在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
//
//例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
//请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
public class 课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inNode = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            inNode[prerequisites[i][0]]++;
            map.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < inNode.length; i++) {
            if (inNode[i] == 0) {
                que.offer(i);
            }
        }
        while (!que.isEmpty()) {
            int i = que.poll();
            numCourses--;
            for (int j : map.getOrDefault(i, new ArrayList<>())) {
                inNode[j]--;

                if (inNode[j] == 0) {
                    que.offer(j);
                }
            }
        }

        return numCourses == 0;
    }
}
