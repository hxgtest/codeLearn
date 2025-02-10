package hot100and150.数组;

/**
 * @author hxg
 * @description: 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * @date 2025/2/10 13:09
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix=strs[0];
        int count=strs.length;
        for(int i=1;i<strs.length;i++){
            prefix=longestCommonPrefix(prefix,strs[i]);
        }
        return prefix;
    }
    public String longestCommonPrefix(String a,String b){
        int length=Math.min(a.length(),b.length());
        int index=0;
        while(index<length&&a.charAt(index)==b.charAt(index)){
            index++;
        }
        return a.substring(0,index);
    }
}
