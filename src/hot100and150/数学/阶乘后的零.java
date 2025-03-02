package hot100and150.数学;

/**
 * @author hxg
 * @description: 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * @date 2025/3/2 11:09
 */
public class 阶乘后的零 {
    public int trailingZeroes(int n) {
        //只有5的倍数会造成尾随0
        int sum=0;
        for(int i=1;i<=n;i++){
            for(int x=i;x%5==0;x/=5){
                sum++;
            }
        }
        return sum;
    }
}
