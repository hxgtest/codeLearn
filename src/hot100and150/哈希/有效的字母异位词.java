package hot100and150.哈希;

/**
 * @author hxg
 * @description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的
 * 字母异位词
 * @date 2025/2/15 10:35
 */
public class 有效的字母异位词   {
    public boolean isAnagram(String s, String t) {
        int[] sum=new int[26];
        for(char c:s.toCharArray()){
            int index=c-'a';
            sum[index]++;
        }
        for(char c:t.toCharArray()){
            int index=c-'a';
            sum[index]--;
        }
        for(int i:sum){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
