package 代码随想录.字符串;

/**
 * @author hxg
 * @description: 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * @date 2024/9/29 22:00
 */
public class 反转字符串Ⅱ {
    public String reverseStr(String s, int k) {
        int n=s.length();
        char[] chars=s.toCharArray();
        for(int i=0;i<n;i+=2*k){
            int right=i+k>n?s.length()-1:i+k-1;
            int left=i;
            reverseString(chars,left,right);
        }
        return new String(chars);
    }
    public void reverseString(char[] s,int left,int right) {
        int n=s.length;

        while (left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}
