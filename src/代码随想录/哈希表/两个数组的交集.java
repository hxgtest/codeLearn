package 代码随想录.哈希表;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author hxg
 * @description: 给定两个数组 nums1 和 nums2 ，返回 它们的
 * 交集
 *  。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序
 * @date 2024/9/28 20:50
 */
public class 两个数组的交集 {
    public int[] intersection(int[] nums1,int[] nums2){
        List<Integer> ans=new LinkedList<>();
        Set<Integer> rec=new HashSet<>();
        for(int i:nums1){
            rec.add(i);
        }
        for(int i:nums2){
            if(rec.contains(i)){
                if(!ans.contains(i)){
                    ans.add(i);
                }
            }
        }
        int[] res=new int[ans.size()];
        int i=0;
        for(int num:ans){
            res[i++]=num;
        }
        return res;
    }
}
