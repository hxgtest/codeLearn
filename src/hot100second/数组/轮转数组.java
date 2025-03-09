package hot100second.数组;

/**
 * @author hxg
 * @description: 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @date 2025/3/10 00:33
 */
public class 轮转数组 {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int temp=0;
        k=k%n;
        int count=gcd(n,k);
        for(int i=0;i<count;i++){
            int prev=nums[i];
            int j=i;
            do {
                int next=(j+k)%n;
                temp=nums[next];
                nums[next]=prev;
                prev=temp;
                j=next;
            }while (j!=i);
        }
    }
    public int gcd(int x,int y){
        return y>0?gcd(y,x%y):x;
    }
}
