package 代码随想录.字符串;
/*
给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
*/
public class 重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).indexOf(s,1)!=s.length();
    }
    public boolean repeatedSubstringPattern1(String s){
        return kmp(s+s,s);

    }
    public boolean kmp(String query,String pattern){
        int[] next=new int[pattern.length()+1];
        int n=pattern.length();
        for(int j=2,i=0;j<=n;j++){
            while(i>0&&pattern.charAt(i)!=pattern.charAt(j-1)){
                i=next[i];
            }
            if(pattern.charAt(i)==pattern.charAt(j-1)){
                i++;
            }
            next[j]=i;
        }
        for(int i=1,j=0;i<query.length()-1;i++){
            while(j>0&&query.charAt(i)!=pattern.charAt(j)){
                j=next[j];
            }
            if(query.charAt(i)==pattern.charAt(j)){
                j++;
            }
            if(j==pattern.length()){
                return true;
            }
        }
        return false;
    }
}
