package hot100and150.数组;

import java.util.Arrays;

/**
 * @author hxg
 * @description: 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 *
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * @date 2025/2/8 17:11
 */
public class H指数274 {
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int h=0,i=citations.length-1;
        while(i>=0&&citations[i]>h){
            h++;i--;
        }
        return h;
    }
    public int hIndex2(int[] citations) {
        int n=citations.length;
        int[] count=new int[n+1];
        for (int citation : citations) {
            if (citation >= n) {
                count[n]++;
            } else {
                count[citation]++;
            }
        }
        int sum=0;
        for(int i=n;i>=0;i--){
            sum+=count[i];
            if(sum>=i){
                return i;
            }
        }
        return 0;

    }
    public int hIndex3(int[] citations) {
        int left=0,right=citations.length;
        int mid=0,cnt=0;
        while (left<right){
            mid=(left+right+1)>>1;
            cnt=0;
            for(int i=0;i<citations.length;i++){
                if(citations[i]>=mid){
                    cnt++;
                }
            }
            if(cnt>=mid){
                left=mid;
            }else {
                right=mid-1;
            }
        }
        return left;
    }
}
