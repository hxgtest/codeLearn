package hot100and150.数组;

/**
 * @author hxg
 * @description: 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * @date 2025/2/11 10:54
 */
public class 找出字符串中第一个匹配项的下标28 {
    public int strStr(String haystack, String needle) {
        int n=haystack.length(),m=needle.length();
        if(m==0){
            return 0;
        }
        int[] next=new int[m];
        for(int i=1,j=0;i<m;i++){
            while(j>0&&needle.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        for(int i=0,j=0;i<n;i++){
            while(j>0&&haystack.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if(haystack.charAt(i)==needle.charAt(j)){
                j++;
            }
            if(j==m){
                return i-j+1;
            }
        }
        return -1;
    }
}
