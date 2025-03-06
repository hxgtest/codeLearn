package hot100second.哈希;

import java.util.*;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/6 09:09
 */
public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> ans=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] array=str.toCharArray();
            Arrays.sort(array);
            String key=new String(array);
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
