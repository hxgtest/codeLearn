package 代码随想录.字符串;

/**
 * @author hxg
 * @description: 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
 * @date 2024/9/29 21:57
 */
public class 反转字符串 {
    public void reverseString(char[] s) {
        int n=s.length;
        int left=0,right=n-1;
        while (left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}
