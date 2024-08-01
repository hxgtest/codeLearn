import java.util.*;

public class Main {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static int findMinArrowShots(int[][] points) {
        int arrows = points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        for (int i = 0; i < points.length - 1; i++) {
            int j = i + 1;
            while (points[j][0] <= points[i][1]) {
                arrows--;
                j++;
            }
            i = j;
        }

        return arrows;
    }

    public static void main(String[] args) {
        int[][] points = new int[2][2];
        points[0][0] = -2147483646;
        points[0][1] = -2147483645;
        points[1][0] = 2147483646;
        points[1][1] = 2147483647;

        System.out.println(findMinArrowShots(points));
    }

    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int n=stones.length;

            int sum=0;
            for(int i:stones){
                sum+=i;
            }
            int target=sum/2;
            boolean[][] dp=new boolean[n+1][target+1];
            dp[0][0]=true;
            for(int i=0;i<n;i++){
                for(int j=1;j<target+1;j++){
                    if(j>=stones[i]){
                        dp[i+1][j]=dp[i][j]|dp[i-1][j-stones[i]];
                    }else {
                        dp[i+1][j]=dp[i][j];
                    }
                }
            }
            for(int j=target;;j--){
                if(dp[n][j]){
                    return sum-2*j;
                }
            }
        }
    }
}

