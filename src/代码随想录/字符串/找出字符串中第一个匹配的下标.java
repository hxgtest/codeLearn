package 代码随想录.字符串;

/**
 * @author hxg
 * @description: 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1
 * @date 2024/10/1 10:08
 */
public class 找出字符串中第一个匹配的下标 {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()){
            return -1;
        }
        for(int i=0;i<haystack.length();i++){
            for(int j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }else if(j==needle.length()-1){
                    return i;
                }
            }
        }
        return -1;
    }
    public int strStr1(String haystack,String needle){
        int[] next=new int[needle.length()+1];
        int n=needle.length();
        for(int j=2,i=0;j<=n;j++){
            while(i>0&&needle.charAt(i)!=needle.charAt(j-1)){
                i=next[i];
            }
            if(needle.charAt(i)==needle.charAt(j-1)){
                i++;
            }
            next[j]=i;
        }
        for(int i=0,j=0;i<haystack.length();i++){
            while(j>0&&haystack.charAt(i)!=needle.charAt(j)){
                j=next[j];
            }
            if(haystack.charAt(i)==needle.charAt(j)){
                j++;
            }
            if(j==needle.length()){
                return i-j+1;
            }
        }
        return -1;
    }
}
