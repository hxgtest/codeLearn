package hot100and150.位运算;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/2/28 14:46
 */
public class 位1的个数 {
    public int hammingWeight(int n) {
        int ret=0;
        while (n!=0){
            //n&n-1可以将最低位的1置零
            n&=(n-1);
            ret++;
        }
        return ret;
    }
}
