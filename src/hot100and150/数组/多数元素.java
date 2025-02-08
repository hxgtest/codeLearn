package hot100and150.数组;

/**
 * @author hxg
 * @description: 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @date 2025/1/29 16:42
 */
public class 多数元素 {
    public int majorityElement1(int[] nums){
        int winner=0,count=0;
        for(int i:nums){
            if(count==0){
                winner=i;
            }
            if(i==winner){
                count++;
            }else{
                count--;
            }
        }
        return winner;
    }
    public int majorityElement2(int[] nums){
        int votes=0;
        int x=0;
        for(int i:nums){
            if(votes==0){
                x=i;
            }
            if(i==x){
                votes++;
            }else {
                votes--;
            }
        }
        return x;
    }

}
