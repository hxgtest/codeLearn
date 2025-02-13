package hot100and150.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hxg
 * @description: 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 *
 *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 *
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 * @date 2025/2/13 10:47
 */
public class 串联所有单词的子串 {
    public List<Integer> findSubstring(String s, String[] words) {
        int subLen= words.length,wordLen=words[0].length(),sLen=s.length();

        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<wordLen;i++){
            if(i+wordLen*subLen>sLen){
                break;
            }
            Map<String,Integer> map=new HashMap<>();
            //初始化滑动窗口
            for(int j=0;j<subLen;j++){
                String word=s.substring(i+j*wordLen,i+(j+1)*wordLen);
                map.put(word,map.getOrDefault(word,0)+1);
            }
            for(String word:words){
                map.put(word,map.getOrDefault(word,0)-1);
                if(map.get(word)==0){
                    map.remove(word);
                }
            }
            for(int start=i;start<sLen-subLen*wordLen+1;start+=wordLen){
                if(start!=i){
                    String wordNext=s.substring(start+(subLen-1)*wordLen,start+subLen*wordLen);
                    map.put(wordNext,map.getOrDefault(wordNext,0)+1);
                    if(map.get(wordNext)==0){
                        map.remove(wordNext);
                    }
                    String wordPrev=s.substring(start-wordLen,start);
                    map.put(wordPrev,map.getOrDefault(wordPrev,0)-1);
                    if(map.get(wordPrev)==0){
                        map.remove(wordPrev);
                    }
                }
                if(map.isEmpty()){
                    ans.add(start);
                }
            }

        }
        return ans;
    }
}
