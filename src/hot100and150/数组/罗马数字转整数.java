package hot100and150.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/2/9 09:50
 */
public class 罗马数字转整数 {
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        char[] chars=s.toCharArray();
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int value=symbolValues.get(chars[i]);
            if(i<n-1&&value<symbolValues.get(chars[i+1])){
                ans-=value;
            }else {
                ans+=value;
            }
        }
        return ans;
    }
}
