package hot100second.贪心算法;

import java.util.*;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/8 10:46
 */
public class 划分字母区间 {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int num=map.size();
        List<Integer> ans=new ArrayList<>();
        int n=s.length();
        Set<Character> set=new HashSet<>();
        int start=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            set.add(c);
            map.put(c,map.getOrDefault(c,0)-1);
            if(map.get(c)==0){
                map.remove(c);
            }
            if(map.size()+set.size()==num){
                ans.add(i+1-start);
                start=i+1;
                set.clear();
                num=map.size();
            }
        }
        return ans;
    }
    public List<Integer> partitionLabels1(String s){
        int[] last=new int[26];
        int len=s.length();
        for(int i=0;i<len;i++){
            last[s.charAt(i)-'a']=i;
        }
        List<Integer> ans=new ArrayList<>();
        int start=0,end=0;
        for(int i=0;i<len;i++){
            end=Math.max(end,last[s.charAt(i)-'a']);
            if(i==end){
                ans.add(end-start+1);
                start=end+1;
            }
        }
        return ans;
    }
}
