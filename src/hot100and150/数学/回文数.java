package hot100and150.数学;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/1 11:23
 */
public class 回文数 {
    public boolean isPalindrome(int x) {
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        int revertedNumber=0;
        while (x>revertedNumber){
            revertedNumber=revertedNumber*10+x%10;
            x/=10;
        }
        return x==revertedNumber||x==revertedNumber/10;
    }
}
